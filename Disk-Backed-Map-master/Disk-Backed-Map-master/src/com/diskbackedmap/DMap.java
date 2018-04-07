package com.diskbackedmap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DMap<K, V> implements Serializable {

	private TreeMap<K, V> data;

	private LinkedList<K> listOfKeys;

	private final int maxCapacity;

	private File file;

	String fileName;

	public DMap(int maxCapacity, String fileName) {

		if (maxCapacity < 0)
			throw new IllegalArgumentException("Capacity Must be positive");

		this.maxCapacity = maxCapacity;
		this.fileName = fileName;
		this.data = new TreeMap<K, V>();
		listOfKeys = new LinkedList<K>();
		file = new File(fileName);
	}

	public void clear() {
		data.clear();
	}

	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	public boolean put(K key, V value) throws IOException {
		Lock lock = new ReentrantLock(); // for thread safety
		lock.lock();
		if (data.size() == maxCapacity) {
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file, true));
			// if map is full then move certain percent of record in file

			int moveThisMuch = (maxCapacity * 50) / 100;
			int counter = 0;
			for (Entry<K, V> record : data.entrySet()) {
				Food dish = (Food) record.getValue();
				listOfKeys.add(record.getKey());
				buffWriter.append(dish.dishRating + ", " + dish.dishName + ", " + dish.dishCost + "\n");
				counter++;
				if (counter == moveThisMuch)
					break;
				data.remove(record.getKey());
			}

			/*
			 * for (int i = 0; i < listOfKeys.size(); i++) data.remove(listOfKeys.get(i));
			 */
			buffWriter.flush();
			buffWriter.close();
		}
		data.put(key, value);
		lock.unlock();
		return true;
	}

	public V get(K key) {
		Lock lock = new ReentrantLock();
		lock.lock();
		V dish = null;
		if (data.containsKey(key)) {
			dish = data.get(key);
			//System.out.println("game on");
		}
		/*
		 * for (Entry<K, V> lag : data.entrySet()) { System.out.println("Key :" +
		 * lag.getKey() + ":" + "Value :" + lag.getValue().toString() + ":"); }
		 */
		try {
			if (dish == null) {
				int indexOfKey = 1;
				/*
				 * when we put data in file it was in sequence as in arraylist
				 * so we will match the index of key in arraylist and index in file 
				 * this is not the most correct and  fast process but it will pull out something we decided to do.
				 */
				for (K currKey : listOfKeys) {
					if ((Integer) currKey == (Integer) key) {
						String line = null;
						int indexofLine = 1;
						BufferedReader buffReader = new BufferedReader(new FileReader(file));
						while ((line = buffReader.readLine()) != null) {
							if (indexofLine == indexOfKey) {
								String arr[] = line.split(", ");
								Food tempDish = new Food(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
								dish = (V) tempDish;
							}
							indexofLine++;
						}
						buffReader.close();
					}
					indexOfKey++;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dish;
	}

	public int size() {
		return data.size();
	}

	public V remove(Object key) {
		Lock lock = new ReentrantLock();
		lock.lock();
		V dish = null;
		if (data.containsKey(key))
			return data.remove(key);
		else {
			if (listOfKeys.contains(key)) {
				try {
					int indexOfKey = 1;
					Scanner sc = new Scanner(System.in);
					BufferedReader buffReader = new BufferedReader(new FileReader(file));
					System.out.println("Enter Name For Modified File");
					String newFiled = sc.nextLine();
					File newFile = new File(newFiled);
					BufferedWriter buffWriter = new BufferedWriter(new FileWriter(newFile));
					for (K currKey : listOfKeys) {

						if ((Integer) currKey == (Integer) key) {
							String line = null;
							int indexofLine = 1;

							while ((line = buffReader.readLine()) != null) {
								if (indexofLine == indexOfKey) {
									String arr[] = line.split(", ");
									Food tempDish = new Food(Integer.parseInt(arr[0]), arr[1],
											Integer.parseInt(arr[2]));
									dish = (V) tempDish;
								} else if (indexofLine != indexOfKey) {
									String arr[] = line.split(", ");
									buffWriter.append(Integer.parseInt(arr[0]) + ", " + arr[1] + ", "
											+ Integer.parseInt(arr[2]) + "\n");
								}
								indexofLine++;
							}
						}
						indexOfKey++;
					}
					buffReader.close();
					buffWriter.flush();
					buffWriter.close();
					file = newFile;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		lock.unlock();
		return dish;
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return data.entrySet();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public boolean exit() {
		if (file.delete()) {
			System.out.println("File deleted successfully");
			return true;
		} else {
			System.out.println("Failed to delete the file");
			return false;
		}
	}

}
