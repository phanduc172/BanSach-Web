package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	ArrayList<sachbean> ds;
	//Viết hàm getsach: lấy về all sách
	public ArrayList<sachbean> getsach() throws Exception {
		ds = sdao.getsach();
		return ds;
	}
	//Viết hàm: TimMa(String maloai);
		//Trả về all sách có mã loại là: maloai;
	public ArrayList<sachbean> timMa(String mloai) {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds)
			if(s.getMaloai().equals(mloai))
				tam.add(s);
		return tam;
	}

	//Viết hàm: Tìm(String key);
	//Trả về all sách có tên sách hoặc tác giả giống như key
	public ArrayList<sachbean> tim(String key) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds)
			if(s.getTensach().toLowerCase().contains(key.toLowerCase()) ||
					s.getTacgia().toLowerCase().contains(key.toLowerCase()))
				tam.add(s);
		return tam;
	}
}
