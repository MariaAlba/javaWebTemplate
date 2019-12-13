package com.ipartek.formacion.model;

import java.util.List;

//el nombre podria haber sido persistable
public interface IDAO<P> {

	/**
	 * devuelve una lista de perros cualquier tipo de lista. Ponemos la letra P para
	 * la interfaz genérica pq será un POJO. Consigue todos los perros
	 * 
	 * @return lista de pojos
	 */
	List<P> getAll();

	/**
	 * recupera un POJO por su id
	 * 
	 * @param id identificador
	 * @return POJO si lo encuenta, si no null
	 */
	P getbyId(int id);

	/**
	 * Elimina un POJO
	 * 
	 * @param id identificador o index
	 * @return POJO eliminado
	 * @throws Exception si no lo elimina o no lo puede encontrar
	 */
	P delete(int id) throws Exception;

	/**
	 * Modifica un POJO
	 * 
	 * @param id   identificador
	 * @param pojo contiene datos a modificaar
	 * @return POJO modificado
	 * @throws Exception si no lo puede modificar o no lo encuentra
	 */
	P update(int id, P pojo) throws Exception;

	/**
	 * Crea nuevo pojo
	 * 
	 * @param pojo a crear
	 * @return POJO creado con el id nuevo
	 * @throws Exception si no lo puede crear
	 */
	P create(P pojo) throws Exception;

}
