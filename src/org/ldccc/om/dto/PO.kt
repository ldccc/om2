package org.ldccc.om.dto

open class PO(open var id: Int?) {
	constructor() : this(null)
	
	companion object {
		val ID: String = "ID"
	}
	
	open fun <O : PO> boxing(o: O) = String()
}