package application.DTO;


import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *  (DTO)
 *  게시글 정보		
 *  				Java			DB
 *  - 게시글 번호		no				no	
 *  - 제목			title			title
 *  - 작성자			writer			writer
 *  - 내용			content			content
 *  - 등록일자			createdAt		created_at
 *  - 수정일자			updatedAt		updated_at
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class Board {

	private int no;
	@NonNull private String title;
	@NonNull private String writer;
	@NonNull private String content;
	public Date createDate;
	private Date updateDate;
	private int view;
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public String getDate() {
		Date createDate = getCreateDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(createDate);
		return date;
	}
	
	public void setCreateDate (Date createDate) {
		this.createDate = createDate;
	}
	
//	public Board() {
//		this("(제목없음)", "(작성자없음)", "");
//	}
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = new Date();
		this.updateDate = new Date();
		this.view = 0;
	}
	
}