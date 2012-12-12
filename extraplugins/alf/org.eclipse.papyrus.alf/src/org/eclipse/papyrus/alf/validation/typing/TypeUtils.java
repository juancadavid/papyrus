/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.validation.typing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AndExpression;
import org.eclipse.papyrus.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.alf.alf.ClassExtentExpression;
import org.eclipse.papyrus.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.alf.alf.CollectOrIterateOperation;
import org.eclipse.papyrus.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.alf.alf.ConditionalOrExpression;
import org.eclipse.papyrus.alf.alf.ConditionalTestExpression;
import org.eclipse.papyrus.alf.alf.EqualityExpression;
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.Expression;
import org.eclipse.papyrus.alf.alf.ForAllOrExistsOrOneOperation;
import org.eclipse.papyrus.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.InstanceCreationExpression;
import org.eclipse.papyrus.alf.alf.IsUniqueOperation;
import org.eclipse.papyrus.alf.alf.LITERAL;
import org.eclipse.papyrus.alf.alf.LinkOperationExpression;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.alf.alf.NameExpression;
import org.eclipse.papyrus.alf.alf.NonLiteralValueSpecification;
import org.eclipse.papyrus.alf.alf.NullExpression;
import org.eclipse.papyrus.alf.alf.OperationCallExpression;
import org.eclipse.papyrus.alf.alf.OperationCallExpressionWithoutDot;
import org.eclipse.papyrus.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.alf.alf.PropertyCallExpression;
import org.eclipse.papyrus.alf.alf.RelationalExpression;
import org.eclipse.papyrus.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.alf.alf.SelectOrRejectOperation;
import org.eclipse.papyrus.alf.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.alf.alf.SequenceConstructionOrAccessCompletion;
import org.eclipse.papyrus.alf.alf.SequenceElement;
import org.eclipse.papyrus.alf.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.alf.alf.SequenceOperationExpression;
import org.eclipse.papyrus.alf.alf.SequenceReductionExpression;
import org.eclipse.papyrus.alf.alf.ShiftExpression;
import org.eclipse.papyrus.alf.alf.SuffixExpression;
import org.eclipse.papyrus.alf.alf.SuperInvocationExpression;
import org.eclipse.papyrus.alf.alf.ThisExpression;
import org.eclipse.papyrus.alf.alf.TupleElement;
import org.eclipse.papyrus.alf.alf.UNLIMITED_LITERAL;
import org.eclipse.papyrus.alf.alf.UnaryExpression;
import org.eclipse.papyrus.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.alf.alf.ValueSpecification;
import org.eclipse.papyrus.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.alf.validation.AlfJavaValidator;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;

public class TypeUtils {
	
	public static TypeFacade _undefined ; 
	public static TypeFacade _integer ; 
	public static TypeFacade _boolean ; 
	public static TypeFacade _unlimited ; 
	public static TypeFacade _natural ; 
	public static TypeFacade _string ; 
	public static TypeFacade _bitString ; 
	public static TypeExpression _nullExpression ;
	public static TypeFacade _Collection ;
	public static TypeFacade _Set ;
	public static TypeFacade _Bag ;
	public static TypeFacade _Queue ;
	public static TypeFacade _OrderedSet ;
	public static TypeFacade _List ;
	public static TypeFacade _Deque ;
	public static TypeFacade _Map ;
	public static TypeFacade _Entry ;
	
	
	private SuffixExpression suffixToBeIgnored = null ;
	
	public TypeUtils() {
		
	}
	
	public TypeUtils(SuffixExpression suffixToBeIgnored) {
		this.suffixToBeIgnored = suffixToBeIgnored ;
	}
	
	public TypeExpression getTypeOfExpression(Expression exp) {
		return getTypeOfConditionalTestExpression((ConditionalTestExpression)exp) ;
	}
	
	public TypeExpression getTypeOfConditionalTestExpression(ConditionalTestExpression exp) {
		if (exp.getWhenTrue() != null) {
			TypeExpression typeOfCondition = getTypeOfConditionalOrExpression(exp.getExp()) ;
			if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfCondition.getTypeFacade() ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			else {
				if (TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean).isCompatibleWithMe(typeOfCondition) != 3) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("An expression of type Boolean is expected. Found an expression of type " + typeOfCondition.getLabel(), exp, AlfPackage.eINSTANCE.getConditionalTestExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
			}
			TypeExpression typeOfWhenTrue = getTypeOfConditionalTestExpression(exp.getWhenTrue()) ;
			if (typeOfWhenTrue.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfWhenTrue.getTypeFacade() ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			if (exp.getWhenFalse() == null) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("The \'when false\' alternative is missing", exp, AlfPackage.eINSTANCE.getConditionalTestExpression_WhenFalse()) ;				
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			else {
				TypeExpression typeOfWhenFalse = getTypeOfConditionalTestExpression(exp.getWhenFalse()) ;
				if (typeOfWhenFalse.getTypeFacade() instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfWhenFalse.getTypeFacade() ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				else {
					int falseTrueCompatibility = typeOfWhenFalse.isCompatibleWithMe(typeOfWhenTrue) ;
					int trueFalseCompatibility = typeOfWhenTrue.isCompatibleWithMe(typeOfWhenFalse) ;
					if (falseTrueCompatibility == trueFalseCompatibility) {
						if (falseTrueCompatibility == 0) {// No type compatibility between the two alternatives
							ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("The \'when true\' and \'when false\' alternatives must be type compatible", exp, AlfPackage.eINSTANCE.getConditionalTestExpression_WhenTrue()) ;				
							return TypeExpressionFactory.eInstance.createTypeExpression(error);
						}
						else 
							return typeOfWhenTrue ;
					}
					else if (falseTrueCompatibility > trueFalseCompatibility)
						return typeOfWhenFalse ;
					else // falseTrueCompatibility < trueFalseCompatibility
						return typeOfWhenTrue ;
				}
			}
		}
		return getTypeOfConditionalOrExpression((ConditionalOrExpression)exp.getExp()) ;
	}
	
	public TypeExpression getTypeOfConditionalOrExpression(ConditionalOrExpression exp) {
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfConditionalAndExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			else if (TypeExpressionFactory.eInstance.createTypeExpression(_boolean).isCompatibleWithMe(previous) == 0) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Expecting an expression of type Boolean. Found an expression of type " + previous.getLabel(), exp, AlfPackage.eINSTANCE.getConditionalAndExpression_Exp()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfConditionalAndExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				else if (TypeExpressionFactory.eInstance.createTypeExpression(_boolean).isCompatibleWithMe(current) == 0) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Operator || is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")", exp, AlfPackage.eINSTANCE.getConditionalAndExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				previous = current ;
			}
			return current ;
		}
		return getTypeOfConditionalAndExpression((ConditionalAndExpression)exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfConditionalAndExpression(ConditionalAndExpression exp) {
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfInclusiveOrExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			else if (TypeExpressionFactory.eInstance.createTypeExpression(_boolean).isCompatibleWithMe(previous) == 0) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Expecting an expression of type Boolean. Found an expression of type " + previous.getLabel(), exp, AlfPackage.eINSTANCE.getConditionalAndExpression_Exp()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfInclusiveOrExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				else if (TypeExpressionFactory.eInstance.createTypeExpression(_boolean).isCompatibleWithMe(current) == 0) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Operator && is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")", exp, AlfPackage.eINSTANCE.getConditionalAndExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				previous = current ;
			}
			return current ;
		}
		return getTypeOfInclusiveOrExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfInclusiveOrExpression(InclusiveOrExpression exp) {
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfExclusiveOrExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfExclusiveOrExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				argumentTypes.add(current) ;
				List<SignatureFacade> availableSignatures = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures("|") ;
				List<SignatureFacade> applicableSignatures = SignatureFacade.findNearestSignature(argumentTypes, availableSignatures) ;
				if (applicableSignatures.isEmpty() || applicableSignatures.size()>1 ) {
					String message = "Operator | is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")";
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(message, exp, AlfPackage.eINSTANCE.getExclusiveOrExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else
					current = applicableSignatures.get(0).getReturnType() ;
				previous = current ;
			}
			return current ;
		}
		return getTypeOfExclusiveOrExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfExclusiveOrExpression(ExclusiveOrExpression exp) {
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfAndExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfAndExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				argumentTypes.add(current) ;
				List<SignatureFacade> availableSignatures = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures("^") ;
				List<SignatureFacade> applicableSignatures = SignatureFacade.findNearestSignature(argumentTypes, availableSignatures) ;
				if (applicableSignatures.isEmpty() || applicableSignatures.size()>1 ) {
					String message = "Operator ^ is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")";
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(message, exp, AlfPackage.eINSTANCE.getExclusiveOrExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else
					current = applicableSignatures.get(0).getReturnType() ;
				previous = current ;
			}
			return current ;
		}
		return getTypeOfAndExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfAndExpression(AndExpression exp) {
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfEqualityExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfEqualityExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				argumentTypes.add(current) ;
				List<SignatureFacade> availableSignatures = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures("&") ;
				List<SignatureFacade> applicableSignatures = SignatureFacade.findNearestSignature(argumentTypes, availableSignatures) ;
				if (applicableSignatures.isEmpty() || applicableSignatures.size()>1 ) {
					String message = "Operator & is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")";
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(message, exp, AlfPackage.eINSTANCE.getAndExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else
					current = applicableSignatures.get(0).getReturnType() ;
				previous = current ;
			}
			return current ;
		}
		return getTypeOfEqualityExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfEqualityExpression(EqualityExpression exp) {
		if (exp.getExp().size() > 1) {
			for (ClassificationExpression classificationExp : exp.getExp()) {
				TypeExpression argType = getTypeOfClassificationExpression(classificationExp) ;
				if (argType.getTypeFacade() instanceof ErrorTypeFacade)
					return argType ;
			}
			return TypeExpressionFactory.eInstance.createTypeExpression(_boolean);
		}
		return getTypeOfClassificationExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfClassificationExpression(ClassificationExpression exp) {
		if (exp.getOp() != null) {
			TypeExpression typeOfClassifiedPart = getTypeOfRelationalExpression(exp.getExp()) ;
			if (typeOfClassifiedPart.getTypeFacade() instanceof ErrorTypeFacade)
				return typeOfClassifiedPart ;
			TypeFacade typeOfClassificationPart = TypeFacadeFactory.eInstance.createVoidFacade(exp.getTypeName()) ;
			if (typeOfClassificationPart instanceof ErrorTypeFacade)
				return TypeExpressionFactory.eInstance.createTypeExpression(typeOfClassificationPart) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(_boolean);
		}
		return getTypeOfRelationalExpression(exp.getExp()) ;
	}
	
	public TypeExpression getTypeOfRelationalExpression(RelationalExpression exp) {
		if (exp.getOp() != null) {
			TypeExpression typeOfLeft = getTypeOfShiftExpression(exp.getLeft()) ;
			if (typeOfLeft.getTypeFacade() instanceof ErrorTypeFacade)
				return typeOfLeft ;
			if (exp.getRight() != null) {
				TypeExpression typeOfRight = getTypeOfShiftExpression(exp.getRight()) ;
				if (typeOfRight.getTypeFacade() instanceof ErrorTypeFacade)
					return typeOfRight ;
				List<SignatureFacade> availableSignatures = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures(exp.getOp()) ;
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(typeOfLeft) ;
				argumentTypes.add(typeOfRight) ;
				List<SignatureFacade> applicableSignatures = SignatureFacade.findNearestSignature(argumentTypes, availableSignatures) ;
				if (applicableSignatures.isEmpty() || applicableSignatures.size()>1) {
					String message = "Operator " + exp.getOp() + " is undefined for (" + typeOfLeft.getLabel() + ", " + typeOfRight.getLabel() + ")";
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(message, exp, AlfPackage.eINSTANCE.getRelationalExpression_Op()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else {
					return applicableSignatures.get(0).getReturnType() ;
				}
					
			}
			else {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Right operand missing", exp, AlfPackage.eINSTANCE.getRelationalExpression_Left()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
		} 
		return getTypeOfShiftExpression(exp.getLeft()) ;
	}
	
	public TypeExpression getTypeOfShiftExpression(ShiftExpression exp) {
		if (exp.getOp() != null) {
			if (exp.getExp().size() == 2) {
				TypeExpression typeOfLeft = getTypeOfAdditiveExpression(exp.getExp().get(0)) ;
				if (typeOfLeft.getTypeFacade() instanceof ErrorTypeFacade)
					return typeOfLeft ;
				TypeExpression typeOfRight = getTypeOfAdditiveExpression(exp.getExp().get(1)) ;
				if (typeOfRight.getTypeFacade() instanceof ErrorTypeFacade)
					return typeOfRight ;
				return TypeExpressionFactory.eInstance.createTypeExpression(_bitString); // TODO: rely on PrimitiveBehaviors as soon as AlfLibrary is complete
			}
			else if (exp.getExp().size() == 1) {
				TypeExpression typeOfLeft = getTypeOfAdditiveExpression(exp.getExp().get(0)) ;
				if (typeOfLeft.getTypeFacade() instanceof ErrorTypeFacade)
					return typeOfLeft ;
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Right operand missing", exp, AlfPackage.eINSTANCE.getShiftExpression_Exp()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
		}
		return getTypeOfAdditiveExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfAdditiveExpression(AdditiveExpression exp) {
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfMultiplicativeExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfMultiplicativeExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				argumentTypes.add(current) ;
				List<SignatureFacade> availableSignatures = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures(exp.getOp().get(i-1)) ;
				List<SignatureFacade> applicableSignatures = SignatureFacade.findNearestSignature(argumentTypes, availableSignatures) ;
				if (applicableSignatures.isEmpty() || applicableSignatures.size()>1 ) {
					String message = "Operator " + exp.getOp().get(i-1) + " is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")";
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(message, exp, AlfPackage.eINSTANCE.getAdditiveExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else
					current = applicableSignatures.get(0).getReturnType() ;
				previous = current ;
			}
			return current ;
		}
		return getTypeOfMultiplicativeExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfMultiplicativeExpression(MultiplicativeExpression exp) {
		if (exp.getExp() == null || exp.getExp().size() == 0)
			return TypeExpressionFactory.eInstance.createTypeExpression(_undefined) ;
		if (exp.getExp().size() > 1) {
			TypeExpression previous = getTypeOfUnaryExpression(exp.getExp().get(0)) ;
			if (previous.getTypeFacade() instanceof ErrorTypeFacade)
				return previous ;
			TypeExpression current = null ;
			for (int i = 1 ; i<exp.getExp().size() ; i++) {
				List<TypeExpression> argumentTypes = new ArrayList<TypeExpression>() ;
				argumentTypes.add(previous) ;
				current = getTypeOfUnaryExpression(exp.getExp().get(i)) ;
				if (current.getTypeFacade() instanceof ErrorTypeFacade)
					return current ;
				argumentTypes.add(current) ;
				List<SignatureFacade> availableSignatures = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures(exp.getOp().get(i-1)) ;
				List<SignatureFacade> applicableSignatures = SignatureFacade.findNearestSignature(argumentTypes, availableSignatures) ;
				if (applicableSignatures.isEmpty() || applicableSignatures.size()>1) {
					String message = "Operator " + exp.getOp().get(i-1) + " is undefined for (" + previous.getLabel() + ", " + current.getLabel() + ")";
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(message, exp, AlfPackage.eINSTANCE.getMultiplicativeExpression_Exp()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else
					current = applicableSignatures.get(0).getReturnType() ;
				previous = current ;
			}
			
			return current ; 
		}
		return getTypeOfUnaryExpression(exp.getExp().get(0)) ;
	}
	
	public TypeExpression getTypeOfUnaryExpression(UnaryExpression exp) {
		TypeExpression typeOfExp = getTypeOfPrimaryExpression(exp.getExp()) ;
		if (typeOfExp.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfExp ;
		if (exp.getOp() != null) {
			// '!'|'-'|'+'|'$'|'~'
			if (exp.getOp().equals("!")) {
				TypeExpression booleanExpression = TypeExpressionFactory.eInstance.createTypeExpression(_boolean) ;
				if (booleanExpression.isCompatibleWithMe(typeOfExp) == 0) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							"Unrary operator ! does not apply to " + typeOfExp.getLabel(), 
							exp, 
							AlfPackage.eINSTANCE.getUnaryExpression_Op()) ;
					typeOfExp = TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
			}
			else if (exp.getOp().equals("-") || exp.getOp().equals("+")) {
				TypeExpression integerExpression = TypeExpressionFactory.eInstance.createTypeExpression(_integer) ;
				TypeExpression naturalExpression = TypeExpressionFactory.eInstance.createTypeExpression(_natural) ;
				TypeExpression unlimitedExpression = TypeExpressionFactory.eInstance.createTypeExpression(_unlimited) ;
				if (! (integerExpression.isCompatibleWithMe(typeOfExp)!=0 ||
					   naturalExpression.isCompatibleWithMe(typeOfExp) !=0 ||
					   unlimitedExpression.isCompatibleWithMe(typeOfExp) !=0)) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							"Unary operator " + exp.getOp() + " does not apply to "+ typeOfExp.getLabel(), 
							exp, 
							AlfPackage.eINSTANCE.getUnaryExpression_Op()) ;
					typeOfExp = TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
			}
			else if (exp.getOp().equals("$")) {
				// Nothing special to do here
			}
			else if (exp.getOp().equals("~")) {
				TypeExpression integerExpression = TypeExpressionFactory.eInstance.createTypeExpression(_integer) ;
				TypeExpression bitstringExpression = TypeExpressionFactory.eInstance.createTypeExpression(_bitString) ;
				if (! (integerExpression.isCompatibleWithMe(typeOfExp)!=0 ||
					   bitstringExpression.isCompatibleWithMe(typeOfExp) !=0)) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							"Unary operator " + exp.getOp() + " does not apply to "+ typeOfExp.getLabel(), 
							exp, 
							AlfPackage.eINSTANCE.getUnaryExpression_Op()) ;
					typeOfExp = TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
			}
			else {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						"Undefined unary operator", 
						exp, 
						AlfPackage.eINSTANCE.getUnaryExpression_Op()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
		}
		return typeOfExp ;
	}
	
	public TypeExpression getTypeOfPrimaryExpression(PrimaryExpression exp) {
		return getTypeOfValueSpecification(exp.getPrefix()) ;
	}
	
	public TypeExpression getTypeOfValueSpecification(ValueSpecification exp) {
		TypeExpression type = null ;
		if (exp instanceof NameExpression)
			type = getTypeOfNameExpression((NameExpression)exp) ;
		else if (exp instanceof LITERAL)
			type = getTypeOfLITERAL((LITERAL)exp);
		else if (exp instanceof ThisExpression)
			type = getTypeOfThisExpression((ThisExpression)exp);
		else if (exp instanceof SuperInvocationExpression)
			type = getTypeOfSuperInvocationExpression((SuperInvocationExpression)exp);
		else if (exp instanceof InstanceCreationExpression)
			type = getTypeOfInstanceCreationExpression((InstanceCreationExpression)exp) ;
		else if (exp instanceof ParenthesizedExpression)
			type = getTypeOfParenthesizedExpression((ParenthesizedExpression)exp) ;
		else if (exp instanceof NullExpression)
			type = getTypeOfNullExpression((NullExpression)exp) ;
		return type ;
	}
	
	public TypeExpression getTypeOfNullExpression(NullExpression exp) {
		return TypeUtils._nullExpression ;
	}
	
	public TypeExpression getTypeOfInstanceCreationExpression(InstanceCreationExpression exp) {
		TypeExpression typeOfExpression = null ;
		if (exp.getTuple() != null) {
			// first try to determine if the expression directly refers to a Class or a DataType
			try {
				SignatureFacade s = SignatureFacadeFactory.eInstance.createConstructorFacade(exp) ;
				if (s.hasReturnType()) {
					if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored) {
						return getTypeOfSuffixExpression(exp.getSuffix(), s.getReturnType()) ;
					}
					return s.getReturnType() ;
				}
				else {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							"Constructor " + exp.getConstructor().getId() + " is illformed (no return type defined)", 
							exp, 
							AlfPackage.eINSTANCE.getInstanceCreationExpression_Constructor()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
			}
			catch (Exception e) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						e.getMessage(), 
						exp, 
						AlfPackage.eINSTANCE.getInstanceCreationExpression_Constructor()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
		}
		else if (exp.getSequenceConstuctionCompletion() != null) {
			//TODO
		}
		else {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"An instance creation or sequence creation is expected", 
					exp, 
					AlfPackage.eINSTANCE.getInstanceCreationExpression_Constructor()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		return typeOfExpression ;
	}
	
	public TypeExpression getTypeOfSuperInvocationExpression(SuperInvocationExpression exp) {
		if (exp.getOperationCall() != null) {
			TypeExpression typeOfOperationCall = null ;
			int found = 0 ;
			for (Iterator<Classifier> i = AlfJavaValidator.getContextClassifier().getGenerals().iterator() ; i.hasNext() && found <= 1; ) {
				TypeExpression contextType = TypeExpressionFactory.eInstance.createTypeExpression(i.next()) ;
				typeOfOperationCall = getTypeOfOperationCallExpression(exp.getOperationCall(), contextType) ;
				if (! (typeOfOperationCall.getTypeFacade() instanceof ErrorTypeFacade)) {
					found++ ;
				}
			}
			if (found == 0) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						"Could not resolve operation " + exp.getOperationCall().getOperationName() , 
						exp, 
						AlfPackage.eINSTANCE.getSuperInvocationExpression_OperationCall()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else if (found > 1) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						exp.getOperationCall().getOperationName() + " resolves to multiple operations", 
						exp, 
						AlfPackage.eINSTANCE.getSuperInvocationExpression_OperationCall()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else
				return typeOfOperationCall ;
		}
		else if (exp.getOperationCallWithoutDot() != null) {
			if (exp.getClassName() == null || exp.getClassName().length() == 0) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						"Classifier name is missing", 
						exp, 
						AlfPackage.eINSTANCE.getSuperInvocationExpression_ClassName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			int found = 0 ;
			String superClassName = exp.getClassName() ;
			Classifier superClass = null ;
			for (Iterator<Classifier> i = AlfJavaValidator.getContextClassifier().getGenerals().iterator() ; i.hasNext() ; ) {
				Classifier c = i.next() ;
				if (c.getName().equals(superClassName)) {
					found = 1 ;
					superClass = c ;
				}
			}
			if (found > 1) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						superClassName + " resolves to multiple classifiers", 
						exp, 
						AlfPackage.eINSTANCE.getSuperInvocationExpression_ClassName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else if (found == 0) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						"Could not resolve " + superClassName + " as a super classifier of " + AlfJavaValidator.getContextClassifier().getName(), 
						exp, 
						AlfPackage.eINSTANCE.getSuperInvocationExpression_ClassName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else {
				return getTypeOfOperationCallWithoutDotExpression(exp.getOperationCallWithoutDot(), superClass) ;
			}
		}
		ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
									"Operation call is missing", 
									exp, 
									AlfPackage.eINSTANCE.getSuperInvocationExpression_OperationCall()) ;
		return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
	}
	
	public TypeExpression getTypeOfNonLiteralValueSpecification(NonLiteralValueSpecification exp) {
		if (exp instanceof NameExpression)
			return getTypeOfNameExpression((NameExpression)exp) ;
		if (exp instanceof ThisExpression)
			return getTypeOfThisExpression((ThisExpression)exp);
		if (exp instanceof SuperInvocationExpression)
			return getTypeOfSuperInvocationExpression((SuperInvocationExpression)exp) ; 
		if (exp instanceof InstanceCreationExpression)
			return getTypeOfInstanceCreationExpression((InstanceCreationExpression)exp) ;
		if (exp instanceof ParenthesizedExpression)
			return getTypeOfParenthesizedExpression((ParenthesizedExpression)exp) ;
		return null ;
	}
	
	public TypeExpression getTypeOfLITERAL(LITERAL exp) {
		TypeFacade t = _undefined ;
		if (exp instanceof BOOLEAN_LITERAL)
			t = _boolean ;
		else if (exp instanceof STRING_LITERAL)
			t = _string ;
		else if (exp instanceof INTEGER_LITERAL)
			t = _integer ;
		else if (exp instanceof UNLIMITED_LITERAL)
			t = _unlimited ;
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored) {
			return getTypeOfSuffixExpression(exp.getSuffix(), TypeExpressionFactory.eInstance.createTypeExpression(t)) ;
		}
		return TypeExpressionFactory.eInstance.createTypeExpression(t) ;
	}
	
	public TypeExpression getTypeOfParenthesizedExpression(ParenthesizedExpression exp) {
		if (exp.getCasted() != null) // && exp.getSuffix() == null)
			return getTypeOfCastExpression(exp) ;
		TypeExpression typeOfParenthesizedExpression = getTypeOfExpression((Expression)exp.getExpOrTypeCast()) ;
		if (typeOfParenthesizedExpression.getTypeFacade() instanceof ErrorTypeFacade) {
			return typeOfParenthesizedExpression ;
		}
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfParenthesizedExpression) ; 
		return typeOfParenthesizedExpression ;
	}
	
	protected TypeExpression getTypeOfCastExpression(ParenthesizedExpression exp) {
		TypeExpression typeOfCastedPart = getTypeOfNonLiteralValueSpecification(exp.getCasted()) ;
		if (typeOfCastedPart.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfCastedPart ;
		TypeFacade castingTypeFacade = TypeFacadeFactory.eInstance.createVoidFacade(exp.getExpOrTypeCast()) ;
		TypeExpression result = new TypeExpression() ;
		result.setType(castingTypeFacade) ;
		result.setMultiplicity(typeOfCastedPart.getMultiplicity()) ;
		return result ;
	}
	
	protected boolean isACastExpression(NameExpression exp) {
		EObject container = exp.eContainer() ;
		EObject cddCastingPart = exp ;
		while (container != null && ! (container instanceof ParenthesizedExpression)) {
			cddCastingPart = container ;
			container = container.eContainer() ;
		}
		if (container == null)
			return false ;
		else {
			ParenthesizedExpression cddCastExpression = (ParenthesizedExpression)container ;
			if (cddCastingPart.eContainingFeature() == AlfPackage.eINSTANCE.getParenthesizedExpression_ExpOrTypeCast())
				return cddCastExpression.getCasted() != null ;
			else
				return false ;
		}
	}
	
	public TypeExpression getTypeOfNameExpression(NameExpression exp) {
		//
		//if (exp.eContainer() instanceof ClassificationExpression ||
		//		exp.eContainer() instanceof SuperInvocationExpression ||
		//		exp.eContainer() instanceof InvocationOrAssignementOrDeclarationStatement ||
		//		isACastExpression(exp)) {
		//	return TypeExpressionFactory.eInstance.createTypeExpression(_undefined); 
		//}


		
		EObject previousPackage = null ;
		if (exp.getPath() != null) {
			List<UnqualifiedName> path = exp.getPath().getNamespace() ;
			// first resolves the first element of the path
			List<EObject> visiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(exp).resolveByName(path.get(0).getName()) ;
			if (visiblePackages.isEmpty()) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Could not resolve package " + path.get(0).getName(), path.get(0), AlfPackage.eINSTANCE.getUnqualifiedName_Name()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			else if (visiblePackages.size() > 1) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(path.get(0).getName() + " resolves to multiple packages", exp.getPath(), AlfPackage.eINSTANCE.getQualifiedNamePath_Namespace()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			else {
				List<EObject> nestedVisiblePackages ;
				previousPackage = visiblePackages.get(0) ;
				for (int i = 1 ; i<path.size() ; i++) {
					nestedVisiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(previousPackage).resolveByName(path.get(i).getName()) ;
					if (nestedVisiblePackages.isEmpty()) {							
						ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade("Could not resolve package " + path.get(i).getName(), path.get(i), AlfPackage.eINSTANCE.getUnqualifiedName_Name()) ;
						return TypeExpressionFactory.eInstance.createTypeExpression(error);
					}
					else if (nestedVisiblePackages.size() > 1) {
						ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(path.get(i).getName() + " resolves to multiple packages", exp.getPath(), AlfPackage.eINSTANCE.getQualifiedNamePath_Namespace()) ;
						return TypeExpressionFactory.eInstance.createTypeExpression(error);
					}
					previousPackage = nestedVisiblePackages.get(0) ;
				}
			}
		}
		
		// TODO handle the case of a sequence construction expression
		
		TypeExpression typeOfPrefix = null ;
		
		if (exp.getPath() == null) {
			if (exp.getInvocationCompletion()==null) { // && exp.getSequenceConstructionCompletion() == null) {
				List<EObject> visibleVariableOrParametersOrProperties = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(exp).resolveByName(exp.getId()) ;
				if (visibleVariableOrParametersOrProperties.isEmpty()) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							"Could not resolve local variable, property or parameter " + exp.getId(), 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_Id()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				else if (visibleVariableOrParametersOrProperties.size()>1) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							exp.getId() + " resolves to multiple elements", 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_Id()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				else {
					EObject resolved = visibleVariableOrParametersOrProperties.get(0) ;
					typeOfPrefix = TypeExpressionFactory.eInstance.createTypeExpression(resolved) ;
				}
			}
		}
		else {
			// TODO: Handle associations here ?
			// TODO: Handle ClassExtent here ?
		}
		
		if (exp.getInvocationCompletion()!=null ) { //&& exp.getSequenceConstructionCompletion() == null ) {
			List<TypeExpression> arguments = new ArrayList<TypeExpression>() ;
			for (TupleElement e : exp.getInvocationCompletion().getTupleElements()) {
				TypeExpression type = getTypeOfExpression(e.getArgument()) ;
				if (type.getTypeFacade() != null && type.getTypeFacade() instanceof ErrorTypeFacade)
					return type ;
				arguments.add(type) ;
			}
			List<EObject> visibleOperationOrBehaviors = AlfScopeProvider.scopingTool.getVisibleOperationsOrBehaviors(previousPackage != null ? previousPackage : exp).resolveByName(exp.getId()) ;
			if (visibleOperationOrBehaviors.isEmpty()) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						"Could not resolve operation or behavior " + exp.getId(), 
						exp, 
						AlfPackage.eINSTANCE.getNameExpression_Id()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else if (visibleOperationOrBehaviors.size()>1) {
				List<SignatureFacade> availableSignatures = new ArrayList<SignatureFacade>() ;
				for (EObject operation : visibleOperationOrBehaviors) {
					availableSignatures.add(new SignatureFacade(operation)) ;
				}
				List<SignatureFacade> selectedSignatures = SignatureFacade.findNearestSignature(arguments, availableSignatures) ;
				if (selectedSignatures.size() > 1) { // could not infer the actual operations even with type of arguments
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							exp.getId() + " resolves to multiple elements", 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_Id()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				else if (selectedSignatures.size() == 0) {
					String errorMessage = exp.getId() + " does not apply to arguments (" ;
					boolean first = true ;
					for (TypeExpression argType : arguments) {
						if (!first)
							errorMessage += ", " ;
						else
							first = false ;
						errorMessage += argType.getLabel() ;
					}
					errorMessage += ")" ;
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							errorMessage, 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_Id()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else {
					typeOfPrefix = selectedSignatures.get(0).getReturnType() ;
				}
			}
			else {
				SignatureFacade operationOrBehaviorSignature = new SignatureFacade(visibleOperationOrBehaviors.get(0)) ;
				String argumentsAreCompatible = operationOrBehaviorSignature.isCompatibleWithMe(arguments, true) ;
				if (! (argumentsAreCompatible.length() == 0)) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							argumentsAreCompatible, 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_InvocationCompletion()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				typeOfPrefix = operationOrBehaviorSignature.getReturnType() ;
			}
		}

		if (exp.getSequenceConstructionCompletion() != null) {
			SequenceConstructionOrAccessCompletion sequenceAccessOrConstruction = exp.getSequenceConstructionCompletion() ;
			if (sequenceAccessOrConstruction.getAccessCompletion() != null) {
				int prefixUpperBound = typeOfPrefix.getMultiplicity().getUpperBound() ;
				boolean prefixIsOrdered = typeOfPrefix.getMultiplicity().isOrdered() ;
				if (! (prefixUpperBound == -1 || prefixUpperBound > 1)) {
					String errorMessage = "Unexpected index. " + exp.getId() + " is not a collection." ;
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							errorMessage, 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_SequenceConstructionCompletion()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else if (!prefixIsOrdered){
					String errorMessage = "Unexpected index. " + exp.getId() + " is not ordered." ;
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							errorMessage, 
							exp, 
							AlfPackage.eINSTANCE.getNameExpression_SequenceConstructionCompletion()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				TypeExpression typeOfIndex = getTypeOfExpression(sequenceAccessOrConstruction.getAccessCompletion().getAccessIndex()) ;
				if (typeOfIndex.getTypeFacade() instanceof ErrorTypeFacade) {
					return typeOfIndex ;
				}
				else if (! (_integer.isCompatibleWithMe(typeOfIndex.getTypeFacade())== 3 || _natural.isCompatibleWithMe(typeOfIndex.getTypeFacade())==3)) {
					String errorMessage = "Expecting an expression of type Integer. Found an expression of type " + typeOfIndex.getLabel() ;
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							errorMessage, 
							sequenceAccessOrConstruction, 
							AlfPackage.eINSTANCE.getAccessCompletion_AccessIndex()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				else {
					// need to change the multiplicity of typeOfPrefix
					//typeOfPrefix.setMultiplicity(MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(0, 1, false, false)) ;
					typeOfPrefix.setMultiplicity(MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(1, 1, false, false)) ; // TODO: 1..1 is temporary
				}
			}
		}
		
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored) {
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfPrefix) ;
		}
		return typeOfPrefix ;
	}
	
	public TypeExpression getTypeOfThisExpression(ThisExpression exp) {
		TypeExpression typeOfPrefix = TypeExpressionFactory.eInstance.createTypeExpression(AlfJavaValidator.getContextClassifier()) ;
		if (typeOfPrefix.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfPrefix ;
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored) {
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfPrefix) ;
		}
		return typeOfPrefix ;
	}
	
	public TypeExpression getTypeOfSuffixExpression(SuffixExpression exp, TypeExpression typeOfPrefix) {
		// TODO: Support all cases
		EObject source = exp.eContainer() ;
		EStructuralFeature containtFeature = exp.eContainingFeature() ;
		///////////////////////////
		
		if (typeOfPrefix == null) {
			String errorMessage = "Type of prefix is undefined. Could not validate suffix." ;
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		else if (typeOfPrefix.getTypeFacade() == TypeUtils._undefined) {
			String errorMessage = "The invocation prefix has no return parameter." ;
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		
		if (exp instanceof ClassExtentExpression) {
			// TODO
			String errorMessage = "Class extent expressions are not supported in this version of the Alf editor" ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		else if (exp instanceof LinkOperationExpression) {
			// TODO
			String errorMessage = "Link operation expressions are not supported in this version of the Alf editor" ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		else if (exp instanceof OperationCallExpression) {
			return getTypeOfOperationCallExpression((OperationCallExpression)exp, typeOfPrefix) ;
		}
		else if (exp instanceof PropertyCallExpression) {
			return getTypeOfPropertyCallExpression((PropertyCallExpression)exp, typeOfPrefix) ;
		}
		else if (exp instanceof SequenceExpansionExpression) {
			return getTypeOfSequenceExpansionExpression((SequenceExpansionExpression) exp, typeOfPrefix) ;
		}
		else if (exp instanceof SequenceOperationExpression) {
			String errorMessage = "Sequence operation expressions are not supported in this version of the Alf editor" ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		else {// exp instanceof SequenceReductionExpression 
			return getTypeOfSequenceReductionExpression((SequenceReductionExpression) exp, typeOfPrefix) ;
		}
	}

	public TypeExpression getTypeOfSequenceOperationExpression(SequenceOperationExpression exp, TypeExpression typeOfPrefix) {
		return typeOfPrefix ; // TODO
	}
	
	public TypeExpression getTypeOfSequenceReductionExpression(SequenceReductionExpression exp, TypeExpression typeOfPrefix) {
		int upperBoundOfPrefix = typeOfPrefix.getMultiplicityFacade().getUpperBound() ;
		// first check if the prefix is a collection
		if (!(upperBoundOfPrefix > 1) && upperBoundOfPrefix != -1) {
			EObject source = exp.eContainer() ;
			EStructuralFeature containtFeature = exp.eContainingFeature() ;
			String errorMessage = "Prefix must be a collection" ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		
		if (exp.getBehavior() == null) {
			String errorMessage = "Reduction behavior is missing" ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, exp, AlfPackage.eINSTANCE.getSequenceReductionExpression_Behavior()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		
		// first tries to resolve the behavior name
		TypeFacade cddBehaviorFacade = TypeFacadeFactory.eInstance.createVoidFacade(exp.getBehavior()) ;
		if (cddBehaviorFacade instanceof ErrorTypeFacade)
			return TypeExpressionFactory.eInstance.createTypeExpression(cddBehaviorFacade) ;
		
		Classifier cddBehavior = cddBehaviorFacade.extractActualType() ;
		if (! (cddBehavior instanceof Behavior)) {
			String errorMessage = cddBehavior.getName() + " does not resolve to a Behavior" ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, exp, AlfPackage.eINSTANCE.getSequenceReductionExpression_Behavior()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		
		Behavior behavior = (Behavior)cddBehavior ;
		// check that the behavior is a valid reduction behavior
		// i.e., it has exactly two in parameters and one return parameter, all with multiplicity 1
		int n_inputParameters = 0 ;
		boolean invalidReductionBehavior = false ;
		boolean returnParameterFound = false ;
		Classifier paramsType = null ;  
		for (int i = 0 ; i < behavior.getOwnedParameters().size() && !invalidReductionBehavior ; i++) {
			Parameter p = behavior.getOwnedParameters().get(i) ;
			switch (p.getDirection()) {
			case IN_LITERAL:
				n_inputParameters++ ;
				if (n_inputParameters > 2) {
					invalidReductionBehavior = true ;
					break ;
				}
				if (p.getLower() != 1 || p.getUpper() != 1) {
					invalidReductionBehavior = true ;
					break ;	
				}
				if (paramsType == null) {
					paramsType = (Classifier)p.getType() ;
					if (paramsType == null) invalidReductionBehavior = true ;
				}
				else {
					if (paramsType != ((Classifier)p.getType()))
						invalidReductionBehavior = true ;
				}
				break;
			case INOUT_LITERAL:
				invalidReductionBehavior = true ;
				break;
			case OUT_LITERAL:
				invalidReductionBehavior = true ;
				break;
			case RETURN_LITERAL:
				returnParameterFound = true ;
				if (p.getLower() != 1 || p.getUpper() != 1) {
					invalidReductionBehavior = true ;
					break ;	
				}
				if (paramsType == null) {
					paramsType = (Classifier)p.getType() ;
					if (paramsType == null) invalidReductionBehavior = true ;
				}
				else {
					if (paramsType != ((Classifier)p.getType()))
						invalidReductionBehavior = true ;
				}
				break;
			}
		}
		SignatureFacade behaviorFacade = SignatureFacadeFactory.eInstance.createSignatureFacade(behavior) ;
		if (! (!invalidReductionBehavior && returnParameterFound)) {
			String errorMessage = behaviorFacade.getLabel() + " is not a valid reduction behavior. It should have exactly two in parameters, one return parameter, all with multiplicity [1..1], and all with the same type." ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, exp, AlfPackage.eINSTANCE.getSequenceReductionExpression_Behavior()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		
		// The signature is valid. Finally needs to determine if the type of the elements in the collection is compatible with the type of the parameters
		if (TypeFacadeFactory.eInstance.createTypeFacade(paramsType).isCompatibleWithMe(typeOfPrefix.getTypeFacade()) == 0) {
			String errorMessage = behaviorFacade.getLabel() + " does not apply to arguments of type " + typeOfPrefix.getTypeFacade().getLabel() ;
			ErrorTypeFacade unsupportedCase = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, exp, AlfPackage.eINSTANCE.getSequenceReductionExpression_Behavior()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(unsupportedCase) ;
		}
		
		TypeExpression typeOfExpression = TypeExpressionFactory.eInstance.createTypeExpression(typeOfPrefix.getTypeFacade()) ;
		
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfExpression) ;
		return typeOfExpression ;
	}
	
	public TypeExpression getTypeOfSequenceExpansionExpression(SequenceExpansionExpression exp, TypeExpression typeOfPrefix) {
		if (exp instanceof SelectOrRejectOperation) {
			return getTypeOfSelectOrRejectOperation((SelectOrRejectOperation)exp, typeOfPrefix) ;
		}
		else if (exp instanceof CollectOrIterateOperation) {
			return getTypeOfCollectOrIterateOperation((CollectOrIterateOperation)exp, typeOfPrefix) ;
		}
		else if (exp instanceof ForAllOrExistsOrOneOperation) {
			return getTypeOfForAllOrExistsOrOneOperation((ForAllOrExistsOrOneOperation)exp, typeOfPrefix) ;
		}
		else { // exp instanceof IsUniqueOperation
			return getTypeOfIsUniqueOperation((IsUniqueOperation)exp, typeOfPrefix) ;
		}
	}
	
	private TypeExpression getTypeOfIsUniqueOperation(IsUniqueOperation exp, TypeExpression typeOfPrefix) {
		if (exp.getName() == null) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local variable definition is missing", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		// first check that the local variable name is not already used
		if (! AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(exp.eContainer()).resolveByName(exp.getName()).isEmpty()) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local name " + exp.getName() + " is not available", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfCondition = getTypeOfExpression(exp.getExpr()) ;
		if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfCondition ;
		
		int upperBound = typeOfCondition.getMultiplicity().getUpperBound() ;
		
		if (upperBound == 0) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Expression must be typed", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Expr()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfExpression = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean) ;
		
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfExpression) ;
		
		return typeOfExpression ;
	}

	private TypeExpression getTypeOfForAllOrExistsOrOneOperation(ForAllOrExistsOrOneOperation exp, TypeExpression typeOfPrefix) {
		if (exp.getName() == null) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local variable definition is missing", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		// first check that the local variable name is not already used
		if (! AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(exp.eContainer()).resolveByName(exp.getName()).isEmpty()) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local name " + exp.getName() + " is not available", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfCondition = getTypeOfExpression(exp.getExpr()) ;
		if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfCondition ;
		
		if (TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean).isCompatibleWithMe(typeOfCondition) == 0) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Expecting an expression of type Boolean. Found an expression of type " + typeOfCondition.getLabel(), 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Expr()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfExpression = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean) ;
		
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfExpression) ;
		
		return typeOfExpression ;
	}

	private TypeExpression getTypeOfCollectOrIterateOperation(CollectOrIterateOperation exp, TypeExpression typeOfPrefix) {
		if (exp.getName() == null) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local variable definition is missing", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		// first check that the local variable name is not already used
		if (! AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(exp.eContainer()).resolveByName(exp.getName()).isEmpty()) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local name " + exp.getName() + " is not available", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfCondition = getTypeOfExpression(exp.getExpr()) ;
		if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfCondition ;
		
		int lowerBound = typeOfPrefix.getMultiplicity().getLowerBound() * typeOfCondition.getMultiplicity().getLowerBound() ;
		int upperBound = typeOfPrefix.getMultiplicity().getUpperBound() * typeOfCondition.getMultiplicity().getUpperBound() ;
		lowerBound = lowerBound < 0 ? -1 : lowerBound ;
		upperBound = upperBound < 0 ? -1 : upperBound ;
		
		if (upperBound == 0) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Expression must be typed", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Expr()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfExpression = TypeExpressionFactory.eInstance.createTypeExpression(typeOfCondition.getTypeFacade()) ;
		typeOfExpression.setMultiplicity(
				MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(
						lowerBound, // Lower bound
						upperBound, // Upper bound
						typeOfPrefix.getMultiplicity().isUnique(),  // is unique
						typeOfPrefix.getMultiplicity().isOrdered())) ; // is ordered
		
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfExpression) ;
		
		return typeOfExpression ;
	}

	private TypeExpression getTypeOfSelectOrRejectOperation(SelectOrRejectOperation exp, TypeExpression typeOfPrefix) {
		if (exp.getName() == null) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local variable definition is missing", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		// first check that the local variable name is not already used
		if (! AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(exp.eContainer()).resolveByName(exp.getName()).isEmpty()) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Local name " + exp.getName() + " is not available", 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Name()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfCondition = getTypeOfExpression(exp.getExpr()) ;
		if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade)
			return typeOfCondition ;
		
		if (TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean).isCompatibleWithMe(typeOfCondition) == 0) {
			ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
					"Expecting an expression of type Boolean. Found an expression of type " + typeOfCondition.getLabel(), 
					exp, 
					AlfPackage.eINSTANCE.getSequenceExpansionExpression_Expr()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		TypeExpression typeOfExpression = TypeExpressionFactory.eInstance.createTypeExpression(typeOfPrefix.getTypeFacade()) ;
		typeOfExpression.setMultiplicity(
				MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(
						0, // Lower bound
						typeOfPrefix.getMultiplicity().getUpperBound(), // Upper bound
						typeOfPrefix.getMultiplicity().isUnique(),  // is unique
						typeOfPrefix.getMultiplicity().isOrdered())) ; // is ordered
		
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfExpression) ;
		
		return typeOfExpression ;
	}

	public TypeExpression getTypeOfPropertyCallExpression(PropertyCallExpression exp, TypeExpression typeOfPrefix) {
		Classifier type = typeOfPrefix.getTypeFacade().extractActualType() ;
		EObject source = exp.eContainer() ;
		EStructuralFeature containtFeature = exp.eContainingFeature() ;
		if (type == null) {
			String errorMessage = "Type of prefix is \"any\". Could not validate suffix." ;
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		
		List<EObject> matchingProperties = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(type).resolveByName(exp.getPropertyName()) ;
		if (matchingProperties.size() == 0) {
			String errorMessage = "Could not resolve property " + exp.getPropertyName() + " for classifier " + type.getName() ;
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		else if (matchingProperties.size() > 1) {
			String errorMessage = exp.getPropertyName() + " matches multiple properties. Classifier " + type.getName() + " is illformed. Duplicate properties should be renamed or deleted.";
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		else { // exactly one property is matched
			int upperBoundOfPrefix = typeOfPrefix.getMultiplicityFacade().getUpperBound() ;
			if (upperBoundOfPrefix == -1 || upperBoundOfPrefix > 1) {
				String errorMessage = "The prefix of this property call is a collection. An index should be used to access property " + exp.getPropertyName() ;
				ErrorTypeFacade error = 
					TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else {
				TypeExpression typeOfSuffix = TypeExpressionFactory.eInstance.createTypeExpression(matchingProperties.get(0)) ;
				// Before building the type of this suffix, needs to check if there is a valid index
				if (exp.getIndex() != null) {
					if (typeOfSuffix.isACollection()) {
						// TODO needs to validate the index
						TypeExpression typeOfIndex = getTypeOfExpression(exp.getIndex()) ;
						if (typeOfIndex.getTypeFacade() instanceof ErrorTypeFacade) {
							return typeOfIndex ;
						}
						else if (typeOfIndex.isACollection() || typeOfIndex.getTypeFacade() != TypeUtils._integer) {
							String errorMessage = "Expecting an expression of type Integer. Found an expression of type " + typeOfIndex.getLabel() ;
							ErrorTypeFacade error = 
								TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, exp, AlfPackage.eINSTANCE.getPropertyCallExpression_Index()) ;
							return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
						}
						else if (! typeOfSuffix.isOrdered()) {
							String errorMessage = "Unexpected index. " + exp.getPropertyName() + " is not ordered." ;
							ErrorTypeFacade error = 
								TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
							return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
						}
						else {
							typeOfSuffix = TypeExpressionFactory.eInstance.createTypeExpression(typeOfSuffix.getTypeFacade()) ;
						}
					}
					else {
						String errorMessage = "Unexpected index. " + exp.getPropertyName() + " is not a collection." ;
						ErrorTypeFacade error = 
							TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
						return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
					}
				}
				if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
					return getTypeOfSuffixExpression(exp.getSuffix(), typeOfSuffix) ;
				else
					return typeOfSuffix ;
			}
		}
	}
	
	public TypeExpression getTypeOfOperationCallExpression(OperationCallExpression exp, TypeExpression typeOfPrefix) {
		Classifier type = typeOfPrefix.getTypeFacade().extractActualType() ;
		EObject source = exp.eContainer() ;
		EStructuralFeature containingFeature = exp.eContainingFeature() ;
		if (type == null) {
			String errorMessage = "Type of prefix is \"any\". Could not validate suffix." ;
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containingFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		List<TypeExpression> arguments = new ArrayList<TypeExpression>() ;
		for (TupleElement e : exp.getTuple().getTupleElements()) {
			TypeExpression argType = getTypeOfExpression(e.getArgument()) ;
			if (argType.getTypeFacade() != null && argType.getTypeFacade() instanceof ErrorTypeFacade)
				return argType ;
			arguments.add(argType) ;
		}
		List<EObject> matchingOperations = AlfScopeProvider.scopingTool.getVisibleOperationsOrBehaviors(type).resolveByName(exp.getOperationName()) ;
		TypeExpression typeOfSuffix ;
		if (matchingOperations.size() == 0) {
			String errorMessage = "" ;
			ErrorTypeFacade error = null ;
			if (exp.getOperationName().equals("destroy")) {// This is the case of the default destructor
				if (typeOfPrefix.getTypeFacade().extractActualType() instanceof PrimitiveType)
					errorMessage += "Primitive types do not have destructors." ;					
				else if (arguments.size() > 0)
					errorMessage += "Default destructor has not parameters" ;
				if (! (errorMessage.length() == 0)) {
					error = TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containingFeature) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
				}
				return TypeExpressionFactory.eInstance.createTypeExpression(_undefined) ;
			}
			errorMessage = "Could not resolve operation " + exp.getOperationName() + " for classifier " + type.getName() ;
			error = TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containingFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		else if (matchingOperations.size() > 1) {
			List<SignatureFacade> availableSignatures = new ArrayList<SignatureFacade>() ;
			for (EObject operation : matchingOperations) {
				availableSignatures.add(new SignatureFacade(operation)) ;
			}
			List<SignatureFacade> selectedSignatures = SignatureFacade.findNearestSignature(arguments, availableSignatures) ;
			if (selectedSignatures.size() > 1) { // could not infer the actual operations even with type of arguments
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						exp.getOperationName() + " resolves to multiple elements", 
						exp, 
						AlfPackage.eINSTANCE.getOperationCallExpression_OperationName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			else if (selectedSignatures.size() == 0) {
				String errorMessage = exp.getOperationName() + " does not apply to arguments (" ;
				boolean first = true ;
				for (TypeExpression argType : arguments) {
					if (!first)
						errorMessage += ", " ;
					else
						first = false ;
					errorMessage += argType.getLabel() ;
				}
				errorMessage += ")" ;
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						errorMessage, 
						exp, 
						AlfPackage.eINSTANCE.getOperationCallExpression_OperationName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else {
				SignatureFacade operationSignature = selectedSignatures.get(0) ;
				String argumentsAreCompatible = operationSignature.isCompatibleWithMe(arguments, true) ;
				if (! (argumentsAreCompatible.length() == 0)) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							argumentsAreCompatible, 
							exp, 
							AlfPackage.eINSTANCE.getOperationCallExpression_OperationName()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				typeOfSuffix = selectedSignatures.get(0).getReturnType() ;
			}
		}
		else { // exactly one operation is matched
			typeOfSuffix = TypeExpressionFactory.eInstance.createTypeExpression(matchingOperations.get(0)) ;
			SignatureFacade operationSignature = new SignatureFacade(matchingOperations.get(0)) ;
			String argumentsAreCompatible = operationSignature.isCompatibleWithMe(arguments, true) ;
			if (! (argumentsAreCompatible.length() == 0)) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						argumentsAreCompatible, 
						exp, 
						AlfPackage.eINSTANCE.getOperationCallExpression_OperationName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			typeOfSuffix = operationSignature.getReturnType() ;
		}
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfSuffix) ;
		else
			return typeOfSuffix ;
	}
	
	public TypeExpression getTypeOfOperationCallWithoutDotExpression(OperationCallExpressionWithoutDot exp, Classifier contextClassifier) {
		EObject source = exp.eContainer() ;
		EStructuralFeature containtFeature = exp.eContainingFeature() ;
		List<TypeExpression> arguments = new ArrayList<TypeExpression>() ;
		for (TupleElement e : exp.getTuple().getTupleElements()) {
			TypeExpression argType = getTypeOfExpression(e.getArgument()) ;
			if (argType.getTypeFacade() != null && argType.getTypeFacade() instanceof ErrorTypeFacade)
				return argType ;
			arguments.add(argType) ;
		}
		List<EObject> matchingOperations = AlfScopeProvider.scopingTool.getVisibleOperationsOrBehaviors(contextClassifier).resolveByName(exp.getOperationName()) ;
		TypeExpression typeOfSuffix ;
		if (matchingOperations.size() == 0) {
			String errorMessage = "Could not resolve operation " + exp.getOperationName() + " for classifier " + contextClassifier.getName() ;
			ErrorTypeFacade error = 
				TypeFacadeFactory.eInstance.createErrorTypeFacade(errorMessage, source, containtFeature) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		else if (matchingOperations.size() > 1) {
			List<SignatureFacade> availableSignatures = new ArrayList<SignatureFacade>() ;
			for (EObject operation : matchingOperations) {
				availableSignatures.add(new SignatureFacade(operation)) ;
			}
			List<SignatureFacade> selectedSignatures = SignatureFacade.findNearestSignature(arguments, availableSignatures) ;
			if (selectedSignatures.size() > 1) { // could not infer the actual operations even with type of arguments
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						exp.getOperationName() + " resolves to multiple elements", 
						exp, 
						AlfPackage.eINSTANCE.getOperationCallExpressionWithoutDot_OperationName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			else if (selectedSignatures.size() == 0) {
				String errorMessage = exp.getOperationName() + " does not apply to arguments (" ;
				boolean first = true ;
				for (TypeExpression argType : arguments) {
					if (!first)
						errorMessage += ", " ;
					else
						first = false ;
					errorMessage += argType.getLabel() ;
				}
				errorMessage += ")" ;
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						errorMessage, 
						exp, 
						AlfPackage.eINSTANCE.getOperationCallExpressionWithoutDot_OperationName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else {
				SignatureFacade operationSignature = selectedSignatures.get(0) ;
				String argumentsAreCompatible = operationSignature.isCompatibleWithMe(arguments, true) ;
				if (! (argumentsAreCompatible.length() == 0)) {
					ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
							argumentsAreCompatible, 
							exp, 
							AlfPackage.eINSTANCE.getOperationCallExpression_OperationName()) ;
					return TypeExpressionFactory.eInstance.createTypeExpression(error);
				}
				typeOfSuffix = selectedSignatures.get(0).getReturnType() ;
			}
		}
		else { // exactly one operation is matched
			typeOfSuffix = TypeExpressionFactory.eInstance.createTypeExpression(matchingOperations.get(0)) ;
			SignatureFacade operationSignature = new SignatureFacade(matchingOperations.get(0)) ;
			String argumentsAreCompatible = operationSignature.isCompatibleWithMe(arguments, true) ;
			if (! (argumentsAreCompatible.length() == 0)) {
				ErrorTypeFacade error = TypeFacadeFactory.eInstance.createErrorTypeFacade(
						argumentsAreCompatible, 
						exp, 
						AlfPackage.eINSTANCE.getOperationCallExpressionWithoutDot_OperationName()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error);
			}
			typeOfSuffix = operationSignature.getReturnType() ;
		}
		if (exp.getSuffix() != null && exp.getSuffix() != suffixToBeIgnored)
			return getTypeOfSuffixExpression(exp.getSuffix(), typeOfSuffix) ;
		else
			return typeOfSuffix ;
	}
	
	public TypeExpression getTypeOfSequenceElement (SequenceElement s) {
		if (s instanceof Expression)
			return getTypeOfExpression((Expression)s) ;
		else // instanceof SequenceConstructionExpression
			return getTypeOfSequenceConstructionExpression((SequenceConstructionExpression)s) ;
	}
	
	public TypeExpression getTypeOfSequenceConstructionExpression (SequenceConstructionExpression s) {
		String errorMessage = "";
		ErrorTypeFacade error = null ;
		if (s.getSequenceElement() == null || s.getSequenceElement().isEmpty()) {
			errorMessage = "Invalid sequence construction expression." ;
			error = TypeFacadeFactory.eInstance
						.createErrorTypeFacade(errorMessage, s, AlfPackage.eINSTANCE.getSequenceConstructionExpression_SequenceElement()) ;
			return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
		}
		TypeExpression baseType = this.getTypeOfSequenceElement(s.getSequenceElement().get(0)) ;
		if (baseType.getTypeFacade() instanceof ErrorTypeFacade)
			return baseType ;
		if (s.getRangeUpper() != null) { // Sequence is specified as a range
			TypeExpression upperType = this.getTypeOfExpression(s.getRangeUpper()) ;
			if (upperType.getTypeFacade() instanceof ErrorTypeFacade)
				return upperType ;
			if (upperType.isCompatibleWithMe(baseType) != 0)
				return TypeExpressionFactory.eInstance.createTypeExpression(upperType.getTypeFacade(), 0, -1, false, true) ;
			else if (baseType.isCompatibleWithMe(upperType) != 0)
				return TypeExpressionFactory.eInstance.createTypeExpression(baseType.getTypeFacade(), 0, -1, false, true) ;
			else {
				errorMessage += "All the elements in the sequence must be type compatible." ;
				error = TypeFacadeFactory.eInstance
							.createErrorTypeFacade(errorMessage, s, AlfPackage.eINSTANCE.getSequenceConstructionExpression_SequenceElement()) ;
				return TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
		}
		else {// Values contained in the sequence are enumerated
			List<TypeExpression> typeOfSequenceElements = new ArrayList<TypeExpression>() ;
			typeOfSequenceElements.add(baseType) ;
			for (int i = 1 ; i < s.getSequenceElement().size() ; i ++) {
				TypeExpression t = this.getTypeOfSequenceElement(s.getSequenceElement().get(i)) ;
				if (t.getTypeFacade() instanceof ErrorTypeFacade)
					return t ;
				else
					typeOfSequenceElements.add(t) ;
			}
			TypeExpression commonSuperType = this.findCommonSuperType(typeOfSequenceElements) ;
			if (commonSuperType == null) {
				errorMessage = "All the elements in the sequence must be type compatible." ;
				error = TypeFacadeFactory.eInstance
						.createErrorTypeFacade(errorMessage, s, AlfPackage.eINSTANCE.getSequenceConstructionExpression_SequenceElement()) ;
				commonSuperType = TypeExpressionFactory.eInstance.createTypeExpression(error) ;
			}
			else {
				commonSuperType.setMultiplicity(MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(-1)) ;
			}
			return commonSuperType ;
		}
	}
	
	private TypeExpression findCommonSuperType(List<TypeExpression> l) {
		TypeExpression mostGeneral = l.get(0) ;
		for (int i = 1 ; i < l.size() && mostGeneral != null ; i ++) {
			TypeExpression current = l.get(i) ;
			if (mostGeneral == current)
				;
			else if (current.isCompatibleWithMe(mostGeneral) != 0)
				;
			else if (mostGeneral.isCompatibleWithMe(current) != 0)
				mostGeneral = current ;
			else
				mostGeneral = null ;
		}
		return mostGeneral ;
	}
}
