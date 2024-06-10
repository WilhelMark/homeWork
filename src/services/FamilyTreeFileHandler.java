package services;

import java.io.*;
import models.FamilyTree;

/**
 * Класс FamilyTreeFileHandler обрабатывает файлы с генеалогическими древами.
 * Он обеспечивает сохранение и загрузку генеалогических древ в файлы.
 */
public class FamilyTreeFileHandler implements Serializable {
    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param familyTree генеалогическое древо
     * @param filename  имя файла
     */
    public <T extends Serializable> void saveFamilyTree(FamilyTree<T> familyTree, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(familyTree);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла
     * @return загруженное генеалогическое древо
     */
    public <T extends Serializable> FamilyTree<T> loadFamilyTree(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
            return new FamilyTree<>();
        }
    }
}