package bo;

import java.util.List;
import bean.lichsumuabean;
import dao.lichsumuadao;

public class lichsumuabo {
    private lichsumuadao lsmDao;

    public lichsumuabo() {
        lsmDao = new lichsumuadao();
    }

    public List<lichsumuabean> getLichSuMua(long makh) throws Exception {
        return lsmDao.getLichSuMua(makh);
    }
}
