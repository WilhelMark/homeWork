package services;

import models.Human;
import utils.List;

import java.util.Comparator;

/**
 * Класс RelationshipSearch предоставляет методы для поиска и сортировки родственных связей в генеалогическом древе.
 */
public class RelationshipSearch {
    /**
     * Сортирует список людей по имени в алфавитном порядке.
     *
     * @param familyMembers список людей для сортировки
     * @return отсортированный список людей
     */
    public List<Human> sortByName(List<Human> familyMembers) {
        List<Human> sortedList = new List<>();
        sortedList.addAll(familyMembers.getElements());
        sortedList.getElements().sort(Comparator.comparing(Human::getName));
        return sortedList;
    }

    /**
     * Сортирует список людей по дате рождения.
     *
     * @param familyMembers список людей для сортировки
     * @return отсортированный список людей
     */
    public List<Human> sortByBirthDate(List<Human> familyMembers) {
        List<Human> sortedList = new List<>();
        sortedList.addAll(familyMembers.getElements());
        sortedList.getElements().sort(Comparator.comparing(Human::getBirthDate));
        return sortedList;
    }
}