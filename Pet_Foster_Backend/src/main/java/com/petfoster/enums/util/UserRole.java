package com.petfoster.enums.util;
/**
 * Enum representing the roles a user can have in the system.
 * The possible roles are:
 * <ul>
 *   <li>FOSTER_PARENT: A user who fosters pets.</li>
 *   <li>SHELTER: A user representing a shelter organization.</li>
 *   <li>ADOPTER: A user who adopts pets.</li>
 *   <li>USER: A general user without specific roles.</li>
 * </ul>
 */
public enum UserRole {
	FOSTER_PARENT,
	SHELTER,
	ADOPTER,
	USER
}
