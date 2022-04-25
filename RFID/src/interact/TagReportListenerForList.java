package interact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;

public class TagReportListenerForList implements TagReportListener{
	public Map<String, Tag> tagMap;
	public  List<String> listEPC;
        
        final String NULL_EPC = "0000 0000 0000 0000 0000 0000";
	public TagReportListenerForList() {
		super();
		tagMap = new HashMap<String, Tag>();
		listEPC = new ArrayList<String>();
		
	}
	
	public Map<String, Tag> getTagMap() {
		return tagMap;
	}

	public void setTagMap(Map<String, Tag> tagMap) {
		this.tagMap = tagMap;
	}

	public List<String> getListEPC() {
		return listEPC;
	}

	public void setListEPC(List<String> listEPC) {
		this.listEPC = listEPC;
	}

	@Override
	public void onTagReported(ImpinjReader reader, TagReport report) {
		List<Tag> tags = report.getTags();
		String epc = "";
        for (Tag t : tags) {
		epc = t.getEpc().toString();
        	if(!epc.equalsIgnoreCase("") && !epc.equalsIgnoreCase(NULL_EPC)) {
        		if(tagMap.get(epc) == null) {
        			tagMap.put(epc, t);
        			listEPC.add(epc);
        		}
        	}
        }
	}
}
