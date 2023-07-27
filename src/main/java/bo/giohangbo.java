package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

	public void Them(String masach, String tensach, long gia, long soluong) {
	    for(giohangbean g : ds)
	      if (g.getMasach().equals(masach)) {
	        g.setSoluong(g.getSoluong() + soluong);
	        return;
	      }
	    ds.add(new giohangbean(masach, tensach, gia, soluong));
	  }


	public void Xoa(String masach) {
	    for (giohangbean g : ds)
	      if (g.getMasach().equals(masach)) {
	    	  ds.remove(g);
	    	  return;
	      }
	  }

	public void Sua(String masach, long slm) {
		int n =ds.size();
	    for (int i = 0 ; i < n ; i++ ) {
	    	giohangbean g = ds.get(i);
	    	if (g.getMasach().equals(masach)) {
		        g.setSoluong(slm); //Sửa lại số lượng
	        	ds.set(i, g); // Sửa lại hàng ở vị trí i
		        return;
		    }
	    }
	}


	public long TongTien() {
		long s = 0;
		for (giohangbean g : ds) {
			s = s + g.getThanhtien();
		}
		return s;
	}

	public long TongSLSach() {
		long s = 0;
		for (giohangbean g : ds) {
			s = s + g.getSoluong();
		}
		return s;
	}


}
