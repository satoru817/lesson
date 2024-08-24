
package com.example.samuraitravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//このクラスがコントローラーとして機能するようになる
public class HomeController {
	@GetMapping("/")//HttpリクエストのGetメソッドをそのメソッドに対応付けられる(Mapping)
	public String index() {
		return "index";//呼び出すビューを返している。.htmlは省略する。						
	}

}
