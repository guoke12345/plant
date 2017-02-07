package service.impl;
import java.util.List;
import pojo.Diagnosis;
import service.IDiagnosisService;
import com.framework.core.page.Pagination;
import dao.IDiagnosisDao;
public class DiagnosisServiceImpl implements IDiagnosisService{
	private IDiagnosisDao DiagnosisDao;
	
	public List<Diagnosis> artListByParentId(int parent_id,int type){
		return DiagnosisDao.artListByParentId(parent_id,type);
	}
	public List<Diagnosis> findByDiseasesId(String diseases_id,int type){
		return this.DiagnosisDao.findByDiseasesId(diseases_id, type);
	}
	public void add(Diagnosis Diagnosis) {
		DiagnosisDao.add(Diagnosis);
	}
	public Pagination<Diagnosis> page(int pageno, int pageSize) {
		return DiagnosisDao.page(pageno, pageSize);
	}

	public void modify(Diagnosis art) {
		DiagnosisDao.modify(art);
		
	}

	public void delete(int id) {
		DiagnosisDao.delete(id);
		
	}

	public Diagnosis art(int id) {
		return DiagnosisDao.art(id);
	}

	public List<Diagnosis> allList() {
		return DiagnosisDao.allList();
	}

	
	/*
	 * get set 
	 * 
	 */
	public IDiagnosisDao getDiagnosisDao() {
		return DiagnosisDao;
	}

	public void setDiagnosisDao(IDiagnosisDao diagnosisDao) {
		DiagnosisDao = diagnosisDao;
	}

	
}
