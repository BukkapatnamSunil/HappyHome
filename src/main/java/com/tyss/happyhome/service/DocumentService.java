package com.tyss.happyhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tyss.happyhome.dao.DocumentDao;
import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Document;
import com.tyss.happyhome.exception.Nullexception;

@Service
@Component
public class DocumentService {
	@Autowired
	private DocumentDao documentdao;

	// SAVE DOCUMENT IN SERVICE LAYER
	public ResponseEntity<ResponseStructure<Document>> saveDocument(int userId, Document document) {
		Document doc = documentdao.saveDocument(document);
		if (doc != null) {
			ResponseStructure<Document> response = new ResponseStructure<>();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(doc);
			return new ResponseEntity<ResponseStructure<Document>>(HttpStatus.OK);
		} else {
			throw new Nullexception();
		}
	}

	// FIND BY ID IN SERVICE LAYER
	public ResponseEntity<ResponseStructure<Document>> findById(int id) {
		Document document = documentdao.findById(id);
		if (document != null) {
			ResponseStructure<Document> response = new ResponseStructure<>();
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("Success");
			response.setData(document);
			return new ResponseEntity<ResponseStructure<Document>>(response, HttpStatus.FOUND);
		} else {
			ResponseStructure<Document> response = new ResponseStructure<>();

			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("not found");
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Document>>(response, HttpStatus.NOT_FOUND);

		}

	}

	// GET ALL DOCUMENTS IN SERVICE LAYER
	public ResponseEntity<ResponseStructure<List<Document>>> getAllDocuments() {
		List<Document> list = documentdao.getAllDocuments();
		if (list != null) {
			ResponseStructure<List<Document>> response = new ResponseStructure<>();
			response.setStatusCode(HttpStatus.ACCEPTED.value());
			response.setMessage("Success");
			response.setData(list);
			return new ResponseEntity<ResponseStructure<List<Document>>>(response, HttpStatus.ACCEPTED);

		} else {

			throw new Nullexception();
		}
	}

	// DELETE DOCUMENT IN SERVICE LAYER
	public ResponseEntity<ResponseStructure<String>> deleteDocumentById(int id) {
		String result = documentdao.deleteDocument(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();

		if (result != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Document deleted successfully");
			responseStructure.setData("Documnet with ID " + id + " has been deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Failed to delete the Document");
			responseStructure.setData("Document with ID " + id + " not found");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	// UPADTE DOCUMENT IN SERVICE LAYER<
	public ResponseEntity<ResponseStructure<Document>> updateDocument(Document document) {
		Document doc = documentdao.updateDocumnet(document);
		if (doc != null) {
			ResponseStructure<Document> response = new ResponseStructure<>();
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("Success");
			response.setData(doc);
			return new ResponseEntity<ResponseStructure<Document>>(response, HttpStatus.FOUND);
		} else {
			ResponseStructure<Document> response = new ResponseStructure<>();
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("not found");
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Document>>(response, HttpStatus.NOT_FOUND);

		}

	}

}
