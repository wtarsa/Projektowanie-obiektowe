package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();

		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		getAdditionalProperties(item, propertiesMap);

		return propertiesMap;
	}

	private static void getAdditionalProperties(Item item, Map<String, Object> propertiesMap){
		switch (item.getCategory()){
			case BOOKS:
				propertiesMap.put("Liczba stron", item.getNumberOfPages());
				propertiesMap.put("Twarda oprawa", item.hasHardcover());
				break;

			case ELECTRONICS:
				propertiesMap.put("Mobilny", item.isMobile());
				propertiesMap.put("Gwarancja", item.hasWarranty());
				break;

			case FOOD:
				propertiesMap.put("Data przydatności do spożycia", item.getExpirationDate());
				break;

			case MUSIC:
				propertiesMap.put("Gatunek muzyczny", item.getGenre());
				propertiesMap.put("Dołączone video", item.isVideoIncluded());
				break;
		}
	}
}
