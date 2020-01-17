package ch.heg.ig.sda.data;

import ch.heg.ig.sda.business.Park;
import java.io.*;

public abstract class DataLoader {

    protected Park park;

    public DataLoader(Park park) {
        this.park = park;
    }

    public int loadFromCsv(String csvFile) {
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));

            int i = 0;
            while ( (line = br.readLine()) != null ) {

                if (i > 0) {
                    String csvSplit = ",";
                    String[] splittedLine = line.split(csvSplit);
                    doCsvParse(splittedLine);
                }
                i++;
            }
            return i - 1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            return 0;
    }

    abstract protected void doCsvParse(String[] splittedLine);

}
