package com.tyss.happyhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Document;
import com.tyss.happyhome.service.DocumentService;

@RestController
public class DocumentController {
	@Autowired
	private DocumentService documentservice;
	//SAVE DOCUMENT
	@PostMapping("/savedocument")
	public ResponseEntity<ResponseStructure<Document>> saveDocument(@RequestBody Document document)
	{
		return documentservice.saveDocument(document);
	}
	//FIND BY ID
	@GetMapping("/finddocumentbyid/{id}")
	public ResponseEntity<ResponseStructure<Document>> findById(@PathVariable int id)
	{
		return documentservice.findById(id);
	}
	@GetMapping("/getalldocuments")
	public ResponseEntity<ResponseStructure<List<Document>>> getAllDocument()
	{
		return documentservice.getAllDocuments();
	}
	//UPDATE DOCUMENT
	@GetMapping("/updatedocument")
	public ResponseEntity<ResponseStructure<Document>> updateDocument(@RequestBody Document document)
	{
		return documentservice.updateDocument(document);
		
	}
	//DELETE ADDRESSES
	@GetMapping("/deletedocument/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int id)
	{
		return documentservice.deleteDocumentById(id);
	}
   



}
