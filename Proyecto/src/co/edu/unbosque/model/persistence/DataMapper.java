package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;

public class DataMapper {

	public static Hombre HombreDTOAHombre(HombreDTO dto) {
		return new Hombre(dto.getNombre(), dto.getAlias(), dto.getEdad(), dto.getFechaNacimiento(), dto.getEstatura(),
				dto.getCorreo(), dto.getImagen(), dto.isDisponibilidad(), dto.getContrasena(), dto.getCodigo(),
				dto.getEdadMaxima(), dto.getEdadMinima(), dto.getEstaturaIdeal(), dto.getIngresoProm(),
				dto.isEstadoDivorcio(), dto.getLikesRecibidos(), dto.isIncognito(), dto.getLikesDados(), dto.isVerificado());
	}

	public static HombreDTO HombreAHombreDTO(Hombre entidad) {
		return new HombreDTO(entidad.getNombre(), entidad.getAlias(), entidad.getEdad(), entidad.getFechaNacimiento(),
				entidad.getEstatura(), entidad.getCorreo(), entidad.getImagen(), entidad.isDisponibilidad(),
				entidad.getContrasena(), entidad.getCodigo(), entidad.getEdadMaxima(), entidad.getEdadMinima(),
				entidad.getEstaturaIdeal(), entidad.getIngresoProm(), entidad.isEstadoDivorcio(),
				entidad.getLikesRecibidos(), entidad.isIncognito(), entidad.getLikesDados(), entidad.isVerificado());
	}

	public static Mujer MujerDTOAMujer(MujerDTO dto) {
		return new Mujer(dto.getNombre(), dto.getAlias(), dto.getEdad(), dto.getFechaNacimiento(), dto.getEstatura(),
				dto.getCorreo(), dto.getImagen(), dto.isDisponibilidad(), dto.getContrasena(), dto.getCodigo(),
				dto.getEdadMaxima(), dto.getEdadMinima(), dto.getEstaturaIdeal(), dto.isDivorciada(),
				dto.getIngresosIdeal(), dto.getLikesRecibidos(), dto.isIncognito(), dto.getLikesDados(), dto.isVerificado());
	}

	public static MujerDTO MujerAMujerDTO(Mujer entidad) {
		return new MujerDTO(entidad.getNombre(), entidad.getAlias(), entidad.getEdad(), entidad.getFechaNacimiento(),
				entidad.getEstatura(), entidad.getCorreo(), entidad.getImagen(), entidad.isDisponibilidad(),
				entidad.getContrasena(), entidad.getCodigo(), entidad.getEdadMaxima(), entidad.getEdadMinima(),
				entidad.getEstaturaIdeal(), entidad.isDivorciada(), entidad.getIngresosIdeal(),
				entidad.getLikesRecibidos(), entidad.isIncognito(), entidad.getLikesDados(), entidad.isVerificado());
	}

	public static ArrayList<HombreDTO> listaHombreAListaHombreDTO(ArrayList<Hombre> entidadLista) {
		ArrayList<HombreDTO> dtoLista = new ArrayList<>();
		for (Hombre h : entidadLista) {
			dtoLista.add(new HombreDTO(h.getNombre(), h.getAlias(), h.getEdad(), h.getFechaNacimiento(),
					h.getEstatura(), h.getCorreo(), h.getImagen(), h.isDisponibilidad(), h.getContrasena(),
					h.getCodigo(), h.getEdadMaxima(), h.getEdadMinima(), h.getEstaturaIdeal(), h.getIngresoProm(),
					h.isEstadoDivorcio(), h.getLikesRecibidos(), h.isIncognito(), h.getLikesDados(), h.isVerificado()));
		}
		return dtoLista;
	}

	public static ArrayList<Hombre> listaHombreDTOAListaHombre(ArrayList<HombreDTO> dtoLista) {
		ArrayList<Hombre> entidadLista = new ArrayList<>();
		for (HombreDTO h : dtoLista) {
			entidadLista.add(new Hombre(h.getNombre(), h.getAlias(), h.getEdad(), h.getFechaNacimiento(),
					h.getEstatura(), h.getCorreo(), h.getImagen(), h.isDisponibilidad(), h.getContrasena(),
					h.getCodigo(), h.getEdadMaxima(), h.getEdadMinima(), h.getEstaturaIdeal(), h.getIngresoProm(),
					h.isEstadoDivorcio(), h.getLikesRecibidos(), h.isIncognito(), h.getLikesDados(), h.isVerificado()));
		}
		return entidadLista;
	}

	public static ArrayList<MujerDTO> listaMujerAListaMujerDTO(ArrayList<Mujer> entidadLista) {
		ArrayList<MujerDTO> dtoLista = new ArrayList<>();
		for (Mujer m : entidadLista) {
			dtoLista.add(new MujerDTO(m.getNombre(), m.getAlias(), m.getEdad(), m.getFechaNacimiento(), m.getEstatura(),
					m.getCorreo(), m.getImagen(), m.isDisponibilidad(), m.getContrasena(), m.getCodigo(),
					m.getEdadMaxima(), m.getEdadMinima(), m.getEstaturaIdeal(), m.isDivorciada(), m.getIngresosIdeal(),
					m.getLikesRecibidos(), m.isIncognito(), m.getLikesDados(), m.isVerificado()));
		}
		return dtoLista;
	}

	public static ArrayList<Mujer> listaMujerDTOAListaMujer(ArrayList<MujerDTO> dtoLista) {
		ArrayList<Mujer> entidadLista = new ArrayList<>();
		for (MujerDTO m : dtoLista) {
			entidadLista.add(new Mujer(m.getNombre(), m.getAlias(), m.getEdad(), m.getFechaNacimiento(),
					m.getEstatura(), m.getCorreo(), m.getImagen(), m.isDisponibilidad(), m.getContrasena(),
					m.getCodigo(), m.getEdadMaxima(), m.getEdadMinima(), m.getEstaturaIdeal(), m.isDivorciada(),
					m.getIngresosIdeal(), m.getLikesRecibidos(), m.isIncognito(), m.getLikesDados(), m.isVerificado()));
		}
		return entidadLista;
	}

}
