package com.wisely.highlight_springmvc4.domain;

public class DemoObj {
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//jackson对对象和json做转换时一定需要此非空构造函数
	public DemoObj(){
		super();
	}
	
	public DemoObj(Long id,String name){
		super();
		this.id = id;
		this.name = name;
	}
}
