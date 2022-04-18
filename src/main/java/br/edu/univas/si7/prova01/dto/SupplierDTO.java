package br.edu.univas.si7.prova01.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.univas.si7.prova01.model.Supplier;

public class SupplierDTO {
	
	@NotNull(message = "CNPJ can not be null.")
	@NotEmpty(message = "CNPJ can not be empty.")
    private long cnpj;
    
    @NotNull(message = "Name can not be null.")
	@NotEmpty(message = "Name can not be empty.")
    private String name;
    
    private String lastbuy;
    private String qualityrate;
    private int probnewdeals;


    public SupplierDTO() {
	}
    public SupplierDTO(Supplier supplier) {
        this.cnpj = supplier.getCnpj();
        this.name = supplier.getName();
        this.lastbuy = supplier.getLastBuy();
        this.qualityrate = supplier.getQualityRate();
        this.probnewdeals = supplier.getProbNewDeals();
      
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
	
	@Override
	public String toString() {
		return "SupplierDTO [cnpj=" + cnpj + ", name=" + name + ", last buy=" + lastbuy + ""
				+ ", quality rate=" + qualityrate
				+ ", pobability of new deals =" + probnewdeals + ", ]";
	}
    
	
    
    

}
