package com.alten.ask.view.comp;

import java.util.List;

import com.alten.ask.AskException;
import com.alten.ask.logic.AskLogic;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class AskCompHeader extends CustomComponent implements AskCompInterface {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private HorizontalLayout mainLayout;
	private AskCompLogin askCompLogin;
	private AskCompLanguage askCompLanguage;
	private Label label_1;
	private static final long serialVersionUID = 2L;
	private final AskLogic askLogic;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public AskCompHeader(AskLogic askLogic) {
		this.askLogic = askLogic;
		buildMainLayout();
		setCompositionRoot(mainLayout);
		this.label_1.setContentMode(ContentMode.HTML);
		this.label_1.addStyleName("askFontTitle");
	}

	@Override
	public void init() throws AskException {
		this.askCompLogin.init();
		this.askCompLanguage.init();
	}

	private HorizontalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new HorizontalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);

		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");

		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("ASK");
		mainLayout.addComponent(label_1);
		mainLayout.setExpandRatio(label_1, 1.0f);
		mainLayout.setComponentAlignment(label_1, new Alignment(48));

		// askCompLogin
		askCompLogin = new AskCompLogin(this.askLogic);
		askCompLogin.setImmediate(false);
		askCompLogin.setWidth("-1px");
		askCompLogin.setHeight("-1px");
		mainLayout.addComponent(askCompLogin);

		// askCompLanguage
		askCompLanguage = new AskCompLanguage(this.askLogic);
		askCompLanguage.setImmediate(false);
		askCompLanguage.setWidth("-1px");
		askCompLanguage.setHeight("-1px");
		mainLayout.addComponent(askCompLanguage);

		return mainLayout;
	}

	@Override
	public void addCompsForLoggedUser(List<AbstractComponent> listComponentForLoggedUser) throws AskException {
		this.askCompLogin.addCompsForLoggedUser(listComponentForLoggedUser);
	}

	@Override
	public void addCompsForNoUser(List<AbstractComponent> listComponentForNoUser) throws AskException {
		this.askCompLogin.addCompsForNoUser(listComponentForNoUser);
	}

	public void setVisibility() throws AskException {
		this.askCompLogin.setVisibility();
	}

	public void postLogin() throws AskException {
		this.askCompLogin.postLogin();
	}

	public void postLogout() throws AskException {
		this.askCompLogin.postLogout();
	}

	@Override
	public void doAction(AskActionType askActionType) throws AskException {
		this.askCompLogin.doAction(askActionType);
	}

	@Override
	public void doEnter() throws AskException {
	}

	@Override
	public void onFocus(Object objectForOnFocus) throws AskException {
	}

	@Override
	public void doClick(AskActionType askActionType) throws AskException {
	}

}
