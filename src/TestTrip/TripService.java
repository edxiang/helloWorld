package TestTrip;

import ConvertToPDF.ToPDF;
import com.tietoenator.trip.jxp.TdbException;
import com.tietoenator.trip.jxp.data.TdbComponent;
import com.tietoenator.trip.jxp.data.TdbField;
import com.tietoenator.trip.jxp.data.TdbRecord;
import com.tietoenator.trip.jxp.data.TdbStringField;
import com.tietoenator.trip.jxp.database.TdbDatabaseDesign;
import com.tietoenator.trip.jxp.database.TdbFieldDesign;
import com.tietoenator.trip.jxp.session.TdbSession;
import com.tietoenator.trip.jxp.session.TdbTripNetSession;

import java.io.File;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/8/10.
 */
public class TripService {

    private static String dbName = "TEST_BY_Z";

    public static TdbSession newInstanse() {
        try {
            TdbSession session = new TdbTripNetSession("192.168.88.55", 23457, false);
            session.login("system", "z");
            return session;
        } catch (TdbException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean sessionLogout(TdbSession session) {
        try {
            session.logout();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean upload(String filePath) {
        try {
            TdbSession session = newInstanse();
            TdbDatabaseDesign db = new TdbDatabaseDesign(session);
            db.get(dbName);

            TdbRecord record = new TdbRecord(session, db, false);
            TdbComponent head = record.getHead();

            File file = new File(filePath);
            File pdfFile = new ToPDF().getConvertPDF("OfficeToPDF.exe", file);
            if (pdfFile != null && pdfFile.exists()) {
                TdbStringField pdfField = (TdbStringField) head.createField(db.getFieldByName("FILE"));
                pdfField.copyFromFile(pdfFile.getAbsolutePath());
            } else {
                TdbStringField fileField = (TdbStringField) head.createField(db.getFieldByName("FILE"));
                fileField.copyFromFile(file.getAbsolutePath());
            }



            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<TdbFieldDesign> getFields() {
        try {
            TdbSession session = newInstanse();
            TdbDatabaseDesign db = new TdbDatabaseDesign(session);
            db.get(dbName);
            for(TdbFieldDesign f:db.fields()){
                System.out.print(f.getName()+"-");
            }
            return db.fields();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
