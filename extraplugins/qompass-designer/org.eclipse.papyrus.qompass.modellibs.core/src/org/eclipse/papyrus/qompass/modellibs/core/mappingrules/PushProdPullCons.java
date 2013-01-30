package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

import FCM.Port;
import FCM.util.IMappingRule;
import FCM.util.MapUtil;

import org.eclipse.papyrus.qompass.designer.core.Log;

/**
 * Will generate a suitable callable interface pulling consumer. The port is typed with a primitive type
 * or data type. The generated interface has a "<Type> pull as well as a "boolean hasData ()" operation).
 * 
 * @author ansgar
 */
public class PushProdPullCons implements IMappingRule {

	public Interface getProvided(Port p, InstanceSpecification config) {
		return null;
	}

	public int needsTransaction() {
		return IMappingRule.REQUIRED;
	}

	public Interface getRequired(Port p, InstanceSpecification config) {
		org.eclipse.uml2.uml.Port umlPort = p.getBase_Port();
		Element owner = umlPort.getOwner();
		String ownerStr = "";
		if(owner instanceof NamedElement) {
			ownerStr = " of class " + ((NamedElement)owner).getQualifiedName();
		}
		Log.log(Log.INFO_MSG, Log.CALC_PORTKIND,
			p.getKind().getBase_Class().getName() + " => GetRequired on " + umlPort.getName() + ownerStr);
		Type type = umlPort.getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterface(p, "_", type);

			// obtain derived interface for other port kind (Caveat: some rules get the prefix from the
			// name of the port kind attached to port "p" which would produce wrong results.
			Interface derivedInterfacePushProd = PushProducer.getInstance().getRequired(p, config);
			Interface derivedInterfacePullCons = PullConsumer.getInstance().getRequired(p, config);
			if(derivedInterface == null) {
				return null;
			}

			if(!derivedInterface.getGenerals().contains(derivedInterfacePushProd)) {
				derivedInterface.createGeneralization(derivedInterfacePushProd);
			}
			if(!derivedInterface.getGenerals().contains(derivedInterfacePullCons)) {
				derivedInterface.createGeneralization(derivedInterfacePullCons);
			}


			return derivedInterface;
		} else {
			return null;
		}
	}
}