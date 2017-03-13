package ua.com.shop.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.SneakerFilter;
import ua.com.shop.entity.Sneaker;

public class SneakerSpecification implements Specification<Sneaker> {
	private final SneakerFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private static final Pattern REG = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	public SneakerSpecification(SneakerFilter filter) {
		super();
		this.filter = filter;
		if (REG.matcher(filter.getMax()).matches()) {
			filter.setMaxValue(new BigDecimal(filter.getMax().replace(',', '.')));
		}
		if (REG.matcher(filter.getMin()).matches()) {
			filter.setMinValue(new BigDecimal(filter.getMin().replace(',', '.')));
		}
	}

	private void findByBrand(Root<Sneaker> root, CriteriaQuery<?> query) {
		if (!filter.getBrandId().isEmpty()) {
			predicates.add(root.get("brand").in(filter.getBrandId()));
		}
	}

	private void findBySize(Root<Sneaker> root, CriteriaQuery<?> query) {
		if (!filter.getSizeId().isEmpty()) {
			predicates.add(root.get("size").in(filter.getSizeId()));
		}
	}

	private void findByModel(Root<Sneaker> root, CriteriaQuery<?> query) {
		if (!filter.getModelId().isEmpty()) {
			predicates.add(root.get("model").in(filter.getModelId()));
		}
	}

	private void findBySeason(Root<Sneaker> root, CriteriaQuery<?> query) {
		if (!filter.getSeasonId().isEmpty()) {
			predicates.add(root.get("season").in(filter.getSeasonId()));
		}
	}

	private void findByGender(Root<Sneaker> root, CriteriaQuery<?> query) {
		if (!filter.getGenderId().isEmpty()) {
			predicates.add(root.get("gender").in(filter.getGenderId()));
		}
	}

	private void findByColor(Root<Sneaker> root, CriteriaQuery<?> query) {
		if (!filter.getColorId().isEmpty()) {
			predicates.add(root.get("color").in(filter.getColorId()));
		}
	}

	private void findByPrice(Root<Sneaker> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMaxValue() != null) {
			predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
		}
		if (filter.getMinValue() != null) {
			predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
		}
	}

	@Override
	public Predicate toPredicate(Root<Sneaker> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		findByBrand(root, query);
		findByPrice(root, query, cb);
		findByColor(root, query);
		findByModel(root, query);
		findByGender(root, query);
		findBySeason(root, query);
		findBySize(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
