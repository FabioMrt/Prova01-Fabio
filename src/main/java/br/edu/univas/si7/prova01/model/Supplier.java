package br.edu.univas.si7.prova01.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
                     //extends Auditing<String>
public class Supplier implements Serializable{
	
	@Id
    private long cnpj;
    private String name;
    private String lastbuy;
    private String qualityrate;
    private int probnewdeals;

    public Supplier() {
	}

    public Supplier(String name, long cnpj, String lastbuy, String qualityrate, int probnewdeals) {
		this.cnpj = cnpj;
		this.name = name;
		this.lastbuy = lastbuy;
		this.qualityrate = qualityrate;
		this.probnewdeals = probnewdeals;

		
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastBuy() {
		return lastbuy;
	}

	public void setLastBuy(String lastbuy) {
		this.lastbuy = lastbuy;
	}

	public String getQualityRate() {
		return qualityrate;
	}

	public void setQualityRate(String qualityrate) {
		this.qualityrate = qualityrate;
	}

	public int getProbNewDeals() {
		return probnewdeals;
	}

	public void setProbNewDeals(int probnewdeals) {
		this.probnewdeals = probnewdeals;
	}



//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (long) (cnpj ^ (cnpj >>> 32));
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
	//	if (this == obj)
	//		return true;
//		if (obj == null)
	//		return false;
//		if (getClass() != obj.getClass())
	//		return false;
//		Supplier other = (Supplier) obj;
//		if (cnpj != other.cnpj)
//		return false;
	//	return true;
	//}
       
   
}
