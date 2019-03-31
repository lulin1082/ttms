package cn.tedu.ttms.attachement.dao;

import java.util.List;

import cn.tedu.ttms.attachement.entity.Attachement;
import cn.tedu.ttms.common.dao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachementDao extends BaseDao<Attachement>{

	List<Attachement> findObjects();
	int findObjectByDisgest(@Param("fileDigest") String fileDigest);
}
