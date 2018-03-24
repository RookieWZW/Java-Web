package crm.page;

import java.util.List;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午2:54:46
 * @version :
 * 
 */
public class Page<T> {
	private int pageNum; // 当前页
	private int pageSize; // 每页显示个数
	private int totalRecord; // 总记录是

	private int startIndex; // 开始索引
	private int totalPage; // 总分页数

	private List<T> data; // 分页数据 查询数据库获得

	private int start; // 循环开始
	private int end; // 循环结束

	public Page(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;

		// 0 优化 排除负页
		if (this.pageNum < 0) {
			this.pageNum = 1;
		}

		// 计算
		// 开始索引

		this.startIndex = (this.pageNum - 1) * this.pageSize;

		// 总分页数
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;

		// 动态条 最多显示10分页 前4后5
		this.start = 1;
		this.end = 10;

		// 处理
		if (this.totalPage <= 10) {
			this.end = this.totalPage;
		} else {
			this.start = this.pageNum - 4;
			this.end = this.pageNum + 5;

			if (this.start < 1) {
				this.start = 1;
				this.end = 10;
			}
			if (this.end > this.totalPage) {
				this.end = this.totalPage;

				this.start = this.totalPage - 9;
			}
		}

	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
