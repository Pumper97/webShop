package ua.com.shop.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.dao.SeasonDao;
import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Season;
import ua.com.shop.entity.Size;
import ua.com.shop.entity.Sneaker;
import ua.com.shop.service.BrandService;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.GenderService;
import ua.com.shop.service.ModelService;
import ua.com.shop.service.SeasonService;
import ua.com.shop.service.SizeService;
import ua.com.shop.service.SneakerService;

@Controller
@RequestMapping("/admin/sneaker")
public class CreateSneakerController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private SneakerService sneakerService;
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private ColorService colorService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("genders", genderService.findAll());
		model.addAttribute("seasons", seasonService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("sneakers", sneakerService.findAll());
		return "admin-sneaker";
	}

	@PostMapping
	public String save(@RequestParam int genderId, @RequestParam int seasonId,
			@RequestParam int colorId, @RequestParam int brandId,
			@RequestParam int modelId) {
		Sneaker sneaker = new Sneaker();
		Gender gender = genderService.findOne(genderId);
		Season season = seasonService.findOne(seasonId);
		ua.com.shop.entity.Model model = modelService.findOne(modelId);
		Color color = colorService.findOne(colorId);
		Brand brand = brandService.findOne(brandId);
        sneaker.setBrand(brand);
        sneaker.setColor(color);
        sneaker.setGender(gender);
        sneaker.setModel(model);
        sneaker.setSeason(season);
		sneakerService.save(sneaker);

		return "redirect:/admin/sneaker";
	}
}
