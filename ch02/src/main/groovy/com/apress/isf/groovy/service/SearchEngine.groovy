/**
 * 
 */
package com.apress.isf.groovy.service

import com.apress.isf.groovy.model.Type

/**
 * @author Felipe Gutierrez
 *
 */
interface SearchEngine {
	def findByType(Type documentType)	
	def listAll()
}
