/**
 * 
 */
package com.assignments.udemy.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;

/**
 * @author Somendu
 *
 * @since 09-Sep-2020
 */
public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> stringlist = new ArrayList<String>();

		stringlist.add("test Now");

		stringlist.add("test Now 2");

		stringlist.contains("test Now");

		Iterator iter = stringlist.iterator();

		ListIterator<String> listIter = stringlist.listIterator();

		Set<String> stringSet = new HashSet<String>();

		stringSet.add("test Now");

		stringSet.add("test Now 2");

		stringSet.contains("test Now");

		Iterator iter1 = stringSet.iterator();

		Spliterator<String> listIter1 = stringSet.spliterator();

		TreeSet<String> stringTreeSet = new TreeSet<String>();

		stringTreeSet.add("test Now");

		stringTreeSet.add("test Now 2");

		stringTreeSet.contains("test Now");

		Iterator iter2 = stringTreeSet.iterator();

		Spliterator<String> listIter2 = stringTreeSet.spliterator();

		List<String> stringLinkedList = new LinkedList<String>();

		stringLinkedList.add("test Now");

		stringLinkedList.add("test Now 2");

		stringLinkedList.contains("test Now");

		Iterator iter3 = stringTreeSet.iterator();

		Spliterator<String> listIter3 = stringLinkedList.spliterator();

	}

}
