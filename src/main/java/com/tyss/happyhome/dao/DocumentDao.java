package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.Repository.HappyHomeDocumentRepository;
import com.tyss.happyhome.entity.Document;

@RestController
public class DocumentDao {
	@Autowired
	private HappyHomeDocumentRepository documenetRepository;
	
	//save documnet
	public Document saveDocument(Document document)
	{
		return documenetRepository.save(document);
	}
	//find document object  by id
	public Document findById(int id)
	{
		Optional<Document> opt = documenetRepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	//return list of documents
	public List<Document> getAllDocuments()
	{
		List<Document> list = documenetRepository.findAll();
		return list;
	}
	//delete document
	public Optional<Document> deleteDocument(int id)
	{
		Optional<Document> opt = documenetRepository.findById(id);
		if(opt.isPresent())
		{
		Document add = opt.get();
			documenetRepository.delete(add);
			return opt;
		}
		return null;
	}
	//update Document
		public Document updateDocument(Document document)
		{
			return documenetRepository.save(document);
		}
	

}
