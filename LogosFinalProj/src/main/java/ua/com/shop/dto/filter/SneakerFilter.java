package ua.com.shop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SneakerFilter {
	private String min = "";

	private String max = "";

	private BigDecimal minValue;

	private BigDecimal maxValue;

	private List<Integer> brandId = new ArrayList<>();

	private List<Integer> sizeId = new ArrayList<>();

	private List<Integer> modelId = new ArrayList<>();

	private List<Integer> seasonId = new ArrayList<>();

	private List<Integer> genderId = new ArrayList<>();

	private List<Integer> colorId = new ArrayList<>();

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public List<Integer> getBrandId() {
		return brandId;
	}

	public void setBrandId(List<Integer> brandId) {
		this.brandId = brandId;
	}

	public List<Integer> getSizeId() {
		return sizeId;
	}

	public void setSizeId(List<Integer> sizeId) {
		this.sizeId = sizeId;
	}

	public List<Integer> getModelId() {
		return modelId;
	}

	public void setModelId(List<Integer> modelId) {
		this.modelId = modelId;
	}

	public List<Integer> getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(List<Integer> seasonId) {
		this.seasonId = seasonId;
	}

	public List<Integer> getGenderId() {
		return genderId;
	}

	public void setGenderId(List<Integer> genderId) {
		this.genderId = genderId;
	}

	public List<Integer> getColorId() {
		return colorId;
	}

	public void setColorId(List<Integer> colorId) {
		this.colorId = colorId;
	}

}
