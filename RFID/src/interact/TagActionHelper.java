package interact;

import com.impinj.octane.AntennaConfigGroup;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.ReaderMode;
import com.impinj.octane.ReportConfig;
import com.impinj.octane.ReportMode;
import com.impinj.octane.Settings;
import comon.Constant;

public class TagActionHelper {
	TagReportListenerForList reportListenerForList;
	
	public TagReportListenerForList getReportListenerForList() {
		return reportListenerForList;
	}

	public void setReportListenerForList(TagReportListenerForList reportListenerForList) {
		this.reportListenerForList = reportListenerForList;
	}

	public ImpinjReader startScan() {
		ImpinjReader reader = new ImpinjReader();
		reportListenerForList = new TagReportListenerForList();
		if (Constant.HOST_NAME != null) {
	        System.out.println("Connecting " + Constant.HOST_NAME);
	        try {
				reader.connect(Constant.HOST_NAME);
				Settings settings = reader.queryDefaultSettings();
	
		        ReportConfig report = settings.getReport();
		        report.setIncludeAntennaPortNumber(true);
		        report.setMode(ReportMode.Individual);
	
		        settings.setReaderMode(ReaderMode.AutoSetDenseReader);
	
		        AntennaConfigGroup antennas = settings.getAntennas();
		        antennas.disableAll();
		        antennas.enableById(new short[]{1});
		        antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
		        antennas.getAntenna((short) 1).setIsMaxTxPower(false);
		        antennas.getAntenna((short) 1).setTxPowerinDbm(20.0);
		        antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70);
	
		        reader.setTagReportListener(reportListenerForList);
	
		        System.out.println("Applying Settings");
		        reader.applySettings(settings);
	
		        System.out.println("Starting");
		        reader.start();
			} catch (OctaneSdkException e) {
				System.out.println("Can't start scan: " + Constant.HOST_NAME + " Exception: " + e.getMessage());
				return null;
			}
		}
        return reader;
	}
}
