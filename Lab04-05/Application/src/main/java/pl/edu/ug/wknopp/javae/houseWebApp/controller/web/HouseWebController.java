package pl.edu.ug.wknopp.javae.houseWebApp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.ug.wknopp.javae.houseWebApp.controller.HouseNotFoundException;
import pl.edu.ug.wknopp.javae.houseWebApp.domain.House;
import pl.edu.ug.wknopp.javae.houseWebApp.service.HouseService;

import java.util.List;

@Controller
public class HouseWebController {
    HouseService houseService;

    public HouseWebController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/house")
    public String getAllHouses(Model model){
        List<House> houses = houseService.getAllHouses();
        model.addAttribute("allHouses", houses);
        return "house-All";
    }

    @GetMapping("/house/delete/{id}")
    public String deleteHouse(@PathVariable("id") String id){
        if(!houseService.deleteHouse(id))
            throw new HouseNotFoundException();
        return "redirect:/house";
    }

    @GetMapping("/house/form")
    public String addHouseForm(Model model){
        model.addAttribute("houseToEdit", new House());
        model.addAttribute("button", "Dodaj");
        model.addAttribute("action", "add");
        return "house-Form";
    }

    @GetMapping("/house/form/{id}")
    public String editHouseForm(@PathVariable("id") String id, Model model){
        model.addAttribute("houseToEdit", houseService.getHouse(id));
        model.addAttribute("button", "Edytuj");
        model.addAttribute("action", "edit/"+id);
        return "house-Form";
    }

    @PostMapping("house/edit/{id}")
    public String editHouse(@PathVariable("id") String id, @ModelAttribute House house){
        House updatedHouse = houseService.updateHouse(id, house);
        if(updatedHouse == null){
            throw new HouseNotFoundException();
        }
        return "redirect:/house";
    }

    @PostMapping("/house/add")
    public String addHouse(@ModelAttribute House house){
        houseService.addHouse(house);
        return "redirect:/house";
    }
}
