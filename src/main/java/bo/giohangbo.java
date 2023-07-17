package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

	public void Them(String masach, String tensach, long gia, long soluong) {
	    for (giohangbean g : ds)
	      if (g.getMasach().equals(masach)) {
	        g.setSoluong(g.getSoluong() + soluong);
	        return;
	      }
	    ds.add(new giohangbean(masach, tensach, gia, soluong));
	  }

	public long TongTien() {
		long s = 0;
		for (giohangbean g : ds) {
			s = s + g.getThanhtien();
		}
		return s;
	}
}
