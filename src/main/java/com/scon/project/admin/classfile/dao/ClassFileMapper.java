package com.scon.project.admin.classfile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.scon.project.admin.Class.dto.ClassDTO;
import com.scon.project.admin.classfile.dto.ClassFileDTO;
import com.scon.project.common.paging.Criteria;
import com.scon.project.member.model.dto.MemberDTO;


@Mapper
public interface ClassFileMapper {

	//첨부자료조회
	List<ClassFileDTO> selectClassFileList(Criteria cri);

	//강의첨부자료 게시글 페이징
	int total(Criteria cri);
	
	//강의첨부자료 등록
	int registClassFile(ClassFileDTO classFileList);

	//강사등록
	List<MemberDTO> selectMember();

	//강의명등록
	List<ClassDTO> selectClassName();


	
	
}