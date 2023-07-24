package dao;

import java.util.ArrayList;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		//Tạo thủ công 6 sach
		ds.add(new sachbean("s1","CTDL","Nguyễn Hoàng Long",80000,5,"b1.jpg","tin"));
		ds.add(new sachbean("s2","Lịch sử 10","Phan Văn Duyên",15000,18,"b2.jpg","su"));
		ds.add(new sachbean("s3","Triết học","Nguyễn Nam",12000,9,"b3.jpg","su"));
		ds.add(new sachbean("s4","Giải tích","Nhật Anh",30000,3,"b4.jpg","toan"));
		ds.add(new sachbean("s5","Lý đại cương","Thanh Phong",20000,14,"b5.jpg","ly"));
		ds.add(new sachbean("s6","Java cơ bản","Hoàng Minh",8000,14,"b6.jpg","tin"));
		return ds;
	}
}
