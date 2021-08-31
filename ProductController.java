package jp.co.internous.leo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.leo.model.domain.MstProduct;
import jp.co.internous.leo.model.mapper.MstProductMapper;
import jp.co.internous.leo.model.session.LoginSession;

/**
 * 商品情報の詳細に関する処理を行うコントローラー
 * @author インターノウス
 * 
 */

@Controller
@RequestMapping("/leo/product")
public class ProductController {
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * 商品詳細画面を初期化する。
	 * @param m 画面表示用オブジェクト
	 * @return 商品詳細画面
	 */
	
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {
		//商品情報を取得
		MstProduct product = productMapper.findById(id);
		m.addAttribute("product",product);
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("loginSession",loginSession);
		
		return "product_detail";
	}
}
