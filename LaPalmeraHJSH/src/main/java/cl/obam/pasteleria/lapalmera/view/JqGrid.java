package cl.obam.pasteleria.lapalmera.view;

import java.util.List;

public class JqGrid {
	
	private String page;
	private String total;
	private String records;
	private List<Object> rows;
	
	public JqGrid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JqGrid(String page, String total, String records, List<Object> rows) {
		super();
		this.page = page;
		this.total = total;
		this.records = records;
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
}
