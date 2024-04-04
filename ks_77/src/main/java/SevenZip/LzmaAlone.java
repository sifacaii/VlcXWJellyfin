package SevenZip;

import SevenZip.Compression.LZMA.Decoder;
import SevenZip.Compression.LZMA.Encoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaAlone.class */
public class LzmaAlone {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaAlone$CommandLine.class */
    public static class CommandLine {
        public static final int kEncode = 0;
        public static final int kDecode = 1;
        public static final int kBenchmak = 2;
        public int Command = -1;
        public int NumBenchmarkPasses = 10;
        public int DictionarySize = 8388608;
        public boolean DictionarySizeIsDefined = false;
        public int Lc = 3;
        public int Lp = 0;
        public int Pb = 2;
        public int Fb = 128;
        public boolean FbIsDefined = false;
        public boolean Eos = false;
        public int Algorithm = 2;
        public int MatchFinder = 1;
        public String InFile;
        public String OutFile;

        boolean ParseSwitch(String s) {
            if (s.startsWith("d")) {
                this.DictionarySize = 1 << Integer.parseInt(s.substring(1));
                this.DictionarySizeIsDefined = true;
                return true;
            } else if (s.startsWith("fb")) {
                this.Fb = Integer.parseInt(s.substring(2));
                this.FbIsDefined = true;
                return true;
            } else if (s.startsWith("a")) {
                this.Algorithm = Integer.parseInt(s.substring(1));
                return true;
            } else if (s.startsWith("lc")) {
                this.Lc = Integer.parseInt(s.substring(2));
                return true;
            } else if (s.startsWith("lp")) {
                this.Lp = Integer.parseInt(s.substring(2));
                return true;
            } else if (s.startsWith("pb")) {
                this.Pb = Integer.parseInt(s.substring(2));
                return true;
            } else if (s.startsWith("eos")) {
                this.Eos = true;
                return true;
            } else if (s.startsWith("mf")) {
                String mfs = s.substring(2);
                if (mfs.equals("bt2")) {
                    this.MatchFinder = 0;
                    return true;
                } else if (mfs.equals("bt4")) {
                    this.MatchFinder = 1;
                    return true;
                } else if (mfs.equals("bt4b")) {
                    this.MatchFinder = 2;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public boolean Parse(String[] args) throws Exception {
            int pos = 0;
            boolean switchMode = true;
            for (String s : args) {
                if (s.length() == 0) {
                    return false;
                }
                if (switchMode) {
                    if (s.compareTo("--") == 0) {
                        switchMode = false;
                    } else if (s.charAt(0) == '-') {
                        String sw = s.substring(1).toLowerCase();
                        if (sw.length() == 0) {
                            return false;
                        }
                        try {
                            if (!ParseSwitch(sw)) {
                                return false;
                            }
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                }
                if (pos == 0) {
                    if (s.equalsIgnoreCase("e")) {
                        this.Command = 0;
                    } else if (s.equalsIgnoreCase("d")) {
                        this.Command = 1;
                    } else if (s.equalsIgnoreCase("b")) {
                        this.Command = 2;
                    } else {
                        return false;
                    }
                } else if (pos == 1) {
                    if (this.Command == 2) {
                        try {
                            this.NumBenchmarkPasses = Integer.parseInt(s);
                            if (this.NumBenchmarkPasses < 1) {
                                return false;
                            }
                        } catch (NumberFormatException e2) {
                            return false;
                        }
                    } else {
                        this.InFile = s;
                    }
                } else if (pos == 2) {
                    this.OutFile = s;
                } else {
                    return false;
                }
                pos++;
            }
            return true;
        }
    }

    static void PrintHelp() {
        System.out.println("\nUsage:  LZMA <e|d> [<switches>...] inputFile outputFile\n  e: encode file\n  d: decode file\n  b: Benchmark\n<Switches>\n  -d{N}:  set dictionary - [0,28], default: 23 (8MB)\n  -fb{N}: set number of fast bytes - [5, 273], default: 128\n  -lc{N}: set number of literal context bits - [0, 8], default: 3\n  -lp{N}: set number of literal pos bits - [0, 4], default: 0\n  -pb{N}: set number of pos bits - [0, 4], default: 2\n  -mf{MF_ID}: set Match Finder: [bt2, bt4], default: bt4\n  -eos:   write End Of Stream marker\n");
    }

    public static void main(String[] args) throws Exception {
        long fileSize;
        System.out.println("\nLZMA (Java) 4.61  2008-11-23\n");
        if (args.length < 1) {
            PrintHelp();
            return;
        }
        CommandLine params = new CommandLine();
        if (!params.Parse(args)) {
            System.out.println("\nIncorrect command");
        } else if (params.Command == 2) {
            int dictionary = 2097152;
            if (params.DictionarySizeIsDefined) {
                dictionary = params.DictionarySize;
            }
            if (params.MatchFinder > 1) {
                throw new Exception("Unsupported match finder");
            }
            LzmaBench.LzmaBenchmark(params.NumBenchmarkPasses, dictionary);
        } else if (params.Command == 0 || params.Command == 1) {
            File inFile = new File(params.InFile);
            File outFile = new File(params.OutFile);
            BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(inFile));
            BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(outFile));
            boolean eos = false;
            if (params.Eos) {
                eos = true;
            }
            if (params.Command == 0) {
                Encoder encoder = new Encoder();
                if (!encoder.SetAlgorithm(params.Algorithm)) {
                    throw new Exception("Incorrect compression mode");
                }
                if (!encoder.SetDictionarySize(params.DictionarySize)) {
                    throw new Exception("Incorrect dictionary size");
                }
                if (!encoder.SetNumFastBytes(params.Fb)) {
                    throw new Exception("Incorrect -fb value");
                }
                if (!encoder.SetMatchFinder(params.MatchFinder)) {
                    throw new Exception("Incorrect -mf value");
                }
                if (!encoder.SetLcLpPb(params.Lc, params.Lp, params.Pb)) {
                    throw new Exception("Incorrect -lc or -lp or -pb value");
                }
                encoder.SetEndMarkerMode(eos);
                encoder.WriteCoderProperties(outStream);
                if (eos) {
                    fileSize = -1;
                } else {
                    fileSize = inFile.length();
                }
                for (int i = 0; i < 8; i++) {
                    outStream.write(((int) (fileSize >>> (8 * i))) & 255);
                }
                encoder.Code(inStream, outStream, -1L, -1L, null);
            } else {
                byte[] properties = new byte[5];
                if (inStream.read(properties, 0, 5) != 5) {
                    throw new Exception("input .lzma file is too short");
                }
                Decoder decoder = new Decoder();
                if (!decoder.SetDecoderProperties(properties)) {
                    throw new Exception("Incorrect stream properties");
                }
                long outSize = 0;
                for (int i2 = 0; i2 < 8; i2++) {
                    int v = inStream.read();
                    if (v < 0) {
                        throw new Exception("Can't read stream size");
                    }
                    outSize |= v << (8 * i2);
                }
                if (!decoder.Code(inStream, outStream, outSize)) {
                    throw new Exception("Error in data stream");
                }
            }
            outStream.flush();
            outStream.close();
            inStream.close();
        } else {
            throw new Exception("Incorrect command");
        }
    }
}
