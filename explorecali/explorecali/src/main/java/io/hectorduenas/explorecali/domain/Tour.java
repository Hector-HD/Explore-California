package io.hectorduenas.explorecali.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Tour {
	@Id
	private String id;
	
	@Indexed
	private String title;
	
	@Indexed
	private String tourPackageCode;
	
	@Indexed
	private String tourPackageName;
	
	@Indexed
    private Map<String, String> details;
		
	protected Tour() {
		
	}

	public Tour(String id, String title, String tourPackageCode, String tourPackageName, Map<String, String> details) {
		super();
		this.id = id;
		this.title = title;
		this.tourPackageCode = tourPackageCode;
		this.tourPackageName = tourPackageName;
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTourPackageCode() {
		return tourPackageCode;
	}

	public void setTourPackageCode(String tourPackageCode) {
		this.tourPackageCode = tourPackageCode;
	}

	public String getTourPackageName() {
		return tourPackageName;
	}

	public void setTourPackageName(String tourPackageName) {
		this.tourPackageName = tourPackageName;
	}

	public Map<String, String> getDetails() {
		return details;
	}

	public void setDetails(Map<String, String> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", title=" + title + ", tourPackageCode=" + tourPackageCode + ", tourPackageName="
				+ tourPackageName + ", details=" + details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tourPackageCode == null) ? 0 : tourPackageCode.hashCode());
		result = prime * result + ((tourPackageName == null) ? 0 : tourPackageName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tourPackageCode == null) {
			if (other.tourPackageCode != null)
				return false;
		} else if (!tourPackageCode.equals(other.tourPackageCode))
			return false;
		if (tourPackageName == null) {
			if (other.tourPackageName != null)
				return false;
		} else if (!tourPackageName.equals(other.tourPackageName))
			return false;
		return true;
	}
	
		
}
