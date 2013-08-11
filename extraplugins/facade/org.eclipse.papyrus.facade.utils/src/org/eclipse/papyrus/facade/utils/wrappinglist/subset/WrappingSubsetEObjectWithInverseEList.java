package org.eclipse.papyrus.facade.utils.wrappinglist.subset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.papyrus.facade.utils.RepresentingElement;
import org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectWithInverseEList;
import org.eclipse.papyrus.facade.utils.wrappinglist.WrappingList;
import org.eclipse.uml2.uml.Element;


public class WrappingSubsetEObjectWithInverseEList<E extends RepresentingElement> extends WrappingEObjectWithInverseEList<E> {

	public static class WrappingSubsetManyInverse<E> extends WrappingSubsetEObjectWithInverseEList {

		private static final long serialVersionUID = 1L;

		public WrappingSubsetManyInverse(Class<?> dataClass, InternalEObject owner, int featureID, int inverseFeatureID, Collection<Element> representedElementList, WrappingList... representingSuperSets) {
			super(dataClass, owner, featureID, inverseFeatureID, representedElementList, representingSuperSets);
		}

		@Override
		protected boolean hasManyInverse() {
			return true;
		}
	}

	protected List<WrappingList<E>> representingSuperSets;

	public WrappingSubsetEObjectWithInverseEList(Class<?> dataClass, InternalEObject owner, int featureID, int inverseFeatureID, Collection<Element> representedElementList, WrappingList<E>... representingSuperSets) {
		super(dataClass, owner, featureID, inverseFeatureID, representedElementList);
		this.representingSuperSets = new ArrayList<WrappingList<E>>();
		for(int i = 0; i < representingSuperSets.length; i++) {
			this.representingSuperSets.add(representingSuperSets[i]);
		}

	}

	@Override
	public boolean add(E object) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			if(!representingSuperSet.contains(object)) {
				representingSuperSet.notWrappingAdd(object);
			}
		}


		return super.add(object);
	}

	@Override
	public void add(int index, E object) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			if(!representingSuperSet.contains(object)) {
				representingSuperSet.notWrappingAdd(object);
			}
		}


		super.add(index, object);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			for(E e : collection) {
				if(!representingSuperSet.contains(e)) {
					representingSuperSet.notWrappingAdd(e);
				}
			}
		}

		return super.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			for(E e : collection) {
				if(!representingSuperSet.contains(e)) {
					representingSuperSet.notWrappingAdd(e);
				}
			}
		}
		return super.addAll(index, collection);
	}

	@Override
	public boolean remove(Object object) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			representingSuperSet.notWrappingRemove((E)object);
		}

		return super.remove(object);
	}

	@Override
	public E remove(int index) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			representingSuperSet.notWrappingRemove(get(index));
		}

		return super.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			for(Object e : collection) {
				representingSuperSet.notWrappingRemove((E)e);
			}
		}

		return super.removeAll(collection);
	}

	@Override
	public void clear() {
		for(WrappingList representingSuperSet : representingSuperSets) {
			for(Object e : this) {
				representingSuperSet.notWrappingRemove((E)e);
			}
		}

		super.clear();
	}

	@Override
	public void notWrappingAdd(E object) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			if(!representingSuperSet.contains(object)) {
				representingSuperSet.notWrappingAdd(object);
			}
		}

		doAddUnique(object);
	}

	@Override
	public E notWrappingRemove(E object) {
		for(WrappingList representingSuperSet : representingSuperSets) {
			representingSuperSet.notWrappingRemove(object);
		}

		return doRemove(indexOf(object));
	}
}
