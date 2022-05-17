package io.appwrite

class Query {
  companion object {
    fun equal(attribute: String, value: Any) = addQuery(attribute, "equal", value)

    fun notEqual(attribute: String, value: Any) = Query.addQuery(attribute, "notEqual", value)

    fun lesser(attribute: String, value: Any) = Query.addQuery(attribute, "lesser", value)

    fun lesserEqual(attribute: String, value: Any) = Query.addQuery(attribute, "lesserEqual", value)

    fun greater(attribute: String, value: Any) = Query.addQuery(attribute, "greater", value)

    fun greaterEqual(attribute: String, value: Any) = Query.addQuery(attribute, "greaterEqual", value)
    
    fun search(attribute: String, value: String) = Query.addQuery(attribute, "search", value)

    private fun addQuery(attribute: String, oper: String, value: Any): String {
      return when (value) {
        is List<*> -> "${attribute}.${oper}(${value.map{it -> parseValues(it!!)}.joinToString(",")})"
    	  else -> "${attribute}.${oper}(${Query.parseValues(value)})"
      }
    }
    private fun parseValues(value: Any): String {
      return when (value) {
        is String -> "\"${value}\""
    	  else -> "${value}"
      }
    }
  }
}
