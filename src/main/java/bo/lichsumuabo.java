package bo;

import java.util.List;

import bean.lichsumuabean;
import dao.lichsumuadao;

public class lichsumuabo {
    private lichsumuadao lichSuMuaDao;

    public lichsumuabo() {
        lichSuMuaDao = new lichsumuadao();
    }

    public List<lichsumuabean> getLichSuMua(long makh) throws Exception {
        return lichSuMuaDao.getLichSuMua(makh);
    }
}
