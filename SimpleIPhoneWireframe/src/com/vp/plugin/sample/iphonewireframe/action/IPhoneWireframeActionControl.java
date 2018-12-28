package com.vp.plugin.sample.iphonewireframe.action;

import java.awt.Color;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.IWFIPhoneDiagramUIModel;
import com.vp.plugin.model.IWFDState;
import com.vp.plugin.model.IWFIOSButton;
import com.vp.plugin.model.IWFIOSImage;
import com.vp.plugin.model.IWFIOSPageControl;
import com.vp.plugin.model.IWFIPhone;
import com.vp.plugin.model.IWFWebLabel;
import com.vp.plugin.model.IWFWebLabelInstance;
import com.vp.plugin.model.IWFWebPanel;
import com.vp.plugin.model.factory.IModelElementFactory;

public class IPhoneWireframeActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// Create blank iPhone Wireframe diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IWFIPhoneDiagramUIModel iPhoneWireframeDiagram = (IWFIPhoneDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_WFI_PHONE_DIAGRAM);
		
		// Create root state and set it to wireframe
		IWFDState rootState = IModelElementFactory.instance().createWFDState();
		iPhoneWireframeDiagram.setRootStateAddress(rootState.getAddress());
		
		// Create iPhone shape
		IWFIPhone iphoneShape = IModelElementFactory.instance().createWFIPhone();		
		// Specify the wireframe widget got the bounds, font, format and model property
		iphoneShape.setHasBounds(true);
		iphoneShape.setHasFont(true);
		iphoneShape.setHasFormat(true);
		iphoneShape.setHasModel(true);		
		// Specify the dimension and coordiate of the wireframe widget
		iphoneShape.setX(100);
		iphoneShape.setY(100);
		iphoneShape.setWidth(400);
		iphoneShape.setHeight(800);		
		// Add the phone shape the root state
		rootState.addElement(iphoneShape);
		
		// Create a panel at the top of the screen (using web wireframe component)
		IWFWebPanel topPanel = IModelElementFactory.instance().createWFWebPanel();
		topPanel.setHasBorder(true);
		topPanel.setHasBounds(true);
		topPanel.setHasFont(true);
		topPanel.setHasFormat(true);
		topPanel.setHasModel(true);
		topPanel.setX(44);
		topPanel.setY(135);
		topPanel.setWidth(319);
		topPanel.setHeight(30);		
		// Specify the phone shape as the parent of the panel
		// and add it to root state
		topPanel.setParentElement(iphoneShape.getId());
		rootState.addElement(topPanel);
		
		// Create more icon on the panel using image shape
		IWFIOSImage moreImage = IModelElementFactory.instance().createWFIOSImage();
		moreImage.setHasBounds(true);
		moreImage.setHasFont(true);
		moreImage.setHasFormat(true);
		moreImage.setHasModel(true);
		moreImage.setX(0);
		moreImage.setY(-3);
		moreImage.setWidth(53);
		moreImage.setHeight(35);
		// Using iOS more icon to represent the image
		moreImage.setImageType(IWFIOSImage.IMAGE_TYPE_MORE);
		moreImage.setParentElement(topPanel.getId());
		rootState.addElement(moreImage);

		// Create normal image shape to present the product image
		IWFIOSImage productImage = IModelElementFactory.instance().createWFIOSImage();
		productImage.setHasBounds(true);
		productImage.setHasFont(true);
		productImage.setHasFormat(true);
		productImage.setHasModel(true);
		productImage.setX(60);
		productImage.setY(184);
		productImage.setWidth(285);
		productImage.setHeight(285);		
		productImage.setParentElement(iphoneShape.getId());
		rootState.addElement(productImage);
		
		// Create page control below product image to represent multiple product images are available
		IWFIOSPageControl pageControl = IModelElementFactory.instance().createWFIOSPageControl();
		pageControl.setHasBounds(true);
		pageControl.setHasFont(true);
		pageControl.setHasFormat(true);
		pageControl.setHasModel(true);
		pageControl.setX(155);
		pageControl.setY(479);
		pageControl.setWidth(96);
		pageControl.setHeight(9);
		// Specify the number page available
		pageControl.setPageCount(6);
		pageControl.setParentElement(iphoneShape.getId());
		rootState.addElement(pageControl);
		
		// Create single line label (using web wireframe component)
		IWFWebLabel labelProductName = IModelElementFactory.instance().createWFWebLabel();
		labelProductName.setHasBounds(true);
		labelProductName.setHasFont(true);
		labelProductName.setHasFormat(true);
		labelProductName.setHasModel(true);
		labelProductName.setX(60);
		labelProductName.setY(499);
		labelProductName.setWidth(250);
		labelProductName.setHeight(20);
		// Specify the font size
		labelProductName.setFontSize(14);
		labelProductName.setParentElement(iphoneShape.getId());
		// Create label instance for contain the actual text element 
		IWFWebLabelInstance labelProductNameInstance = IModelElementFactory.instance().createWFWebLabelInstance();
		// Specify the text content. Otherwise it will automatically
		// present with a gray color bar 
		labelProductNameInstance.setText("Product Name");
		// Add the label instance to label
		labelProductName.addInstance(labelProductNameInstance);
		// Add label instance to root state 
		rootState.addElement(labelProductName);
		
		// Create price label
		IWFWebLabel labelPrice = IModelElementFactory.instance().createWFWebLabel();
		labelPrice.setHasBounds(true);
		labelPrice.setHasFont(true);
		labelPrice.setHasFormat(true);
		labelPrice.setHasModel(true);
		labelPrice.setX(300);
		labelPrice.setY(499);
		labelPrice.setWidth(50);
		labelPrice.setHeight(20);
		labelPrice.setFontSize(14);
		labelPrice.setParentElement(iphoneShape.getId());
		IWFWebLabelInstance labelPriceNameInstance = IModelElementFactory.instance().createWFWebLabelInstance();
		labelPriceNameInstance.setText("$Price");
		labelPrice.addInstance(labelPriceNameInstance);		
		rootState.addElement(labelPrice);
		
		// Create multi-line label to represent product description 
		IWFWebLabel labelProductDesc = IModelElementFactory.instance().createWFWebLabel();
		labelProductDesc.setHasBounds(true);
		labelProductDesc.setHasFont(true);
		labelProductDesc.setHasFormat(true);
		labelProductDesc.setHasModel(true);
		labelProductDesc.setX(60);
		labelProductDesc.setY(529);		
		labelProductDesc.setWidth(285);
		labelProductDesc.setHeight(101);
		labelProductDesc.setFontSize(12);
		labelProductDesc.setEmptyTextBackgroundColor(Color.GRAY.getRGB());
		// Specify the spacing between lines
		labelProductDesc.setLineSpacing(5);
		labelProductDesc.setParentElement(iphoneShape.getId());
		// Create multiple label instance, each represent one line in the label.
		IWFWebLabelInstance labelProductDescInstanceLine1 = IModelElementFactory.instance().createWFWebLabelInstance();
		labelProductDesc.addInstance(labelProductDescInstanceLine1);		
		IWFWebLabelInstance labelProductDescInstanceLine2 = IModelElementFactory.instance().createWFWebLabelInstance();
		labelProductDesc.addInstance(labelProductDescInstanceLine2);		
		IWFWebLabelInstance labelProductDescInstanceLine3 = IModelElementFactory.instance().createWFWebLabelInstance();
		labelProductDesc.addInstance(labelProductDescInstanceLine3);		
		IWFWebLabelInstance labelProductDescInstanceLine4 = IModelElementFactory.instance().createWFWebLabelInstance();
		labelProductDesc.addInstance(labelProductDescInstanceLine4);		
		rootState.addElement(labelProductDesc);
		
		// Create the Add to Cart button
		IWFIOSButton btnAddToCart = IModelElementFactory.instance().createWFIOSButton();
		btnAddToCart.setHasBounds(true);
		btnAddToCart.setHasFont(true);
		btnAddToCart.setHasFormat(true);
		btnAddToCart.setHasModel(true);
		btnAddToCart.setX(150);
		btnAddToCart.setY(640);
		btnAddToCart.setWidth(100);
		btnAddToCart.setHeight(30);
		// Specify the caption of the button
		btnAddToCart.setText("Add to Cart");
		btnAddToCart.setParentElement(iphoneShape.getId());
		rootState.addElement(btnAddToCart);
		
		// Show up the diagram
		diagramManager.openDiagram(iPhoneWireframeDiagram);
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
