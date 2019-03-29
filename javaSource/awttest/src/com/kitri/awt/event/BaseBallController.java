package com.kitri.awt.event;

import java.awt.event.*;

public class BaseBallController implements ActionListener, AdjustmentListener{

	BaseBall baseBall;
	BaseBallService baseBallService;
	
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;
		baseBallService = new BaseBallService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//ListTest 에서 버튼이 눌렸을때...
		Object object = e.getSource();
		
		if (object == baseBall.bMenu[0]) {
			//새게임
			baseBallService.newGame();
			
		} else if(object == baseBall.bMenu[1]) {
			//clear
			baseBallService.clear();
			
		} else if(object == baseBall.bMenu[2]) {
			//정답
			baseBallService.showDap();
			
		} else if(object == baseBall.bMenu[3]) {
			//폰트
			baseBallService.fontColorChange();
			
		} else if(object == baseBall.bMenu[4]) {
			//종료
			baseBallService.exit();
			
		} else if(object == baseBall.tf){
			baseBallService.game();
		} else if(object == baseBall.fontColorChooser.bOk){
			baseBallService.selectColor();
		} else
			return;
		
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		baseBallService.changeColor();
	}
	
}
