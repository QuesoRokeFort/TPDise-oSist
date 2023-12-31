package Hibernate.Util;
import Hibernate.Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
//felipe
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://mysql-polizatp-poliza-tp.a.aivencloud.com:14042/defaultdb?sslMode=REQUIRED");
				settings.put(Environment.USER, "avnadmin");
				settings.put(Environment.PASS, "AVNS_pVDKJ6SyTpAcc-PKJB-");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				// Propiedades SSL
				/*settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.CONNECTION_PROVIDER_DISABLES_AUTOCOMMIT, "true");
				settings.put(Environment.CONNECTION_PROVIDER, "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");*/

				// Configuración SSL adicional
				settings.put("hibernate.sslmode", "REQUIRED");
				settings.put("hibernate.ssl.factory_class", "org.hibernate.ssl.internal.JDK14CompatibleSSLContextFactory");
				settings.put("hibernate.ssl.DOCOMPLETECHAIN", "true");
				settings.put("hibernate.ssl.trustStore", "C:/Users/PC/Desktop/DIed/tptestahorasijaja/src/main/resources/ca.pem");
				//settings.put("hibernate.ssl.trustStorePassword", "contraseña_de_tu_certificado");

				configuration.setProperties(settings);

				// Añadir clases de entidad
				configuration.addPackage("Hibernate.Model");
				configuration.addAnnotatedClass(Pais.class);
				configuration.addAnnotatedClass(Provincia.class);
				configuration.addAnnotatedClass(Localidad.class);
				configuration.addAnnotatedClass(Direccion.class);
				configuration.addAnnotatedClass(Rol.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(TipoDocumento.class);
				configuration.addAnnotatedClass(Profesion.class);
				configuration.addAnnotatedClass(EstadoCivil.class);
				configuration.addAnnotatedClass(Persona.class);
				configuration.addAnnotatedClass(Vehiculo.class);
				configuration.addAnnotatedClass(Modelo.class);
				configuration.addAnnotatedClass(AnioFabricacion.class);
				configuration.addAnnotatedClass(Marca.class);
				configuration.addAnnotatedClass(ModeloAnioFabricacion.class);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(TipoCobertura.class);
				configuration.addAnnotatedClass(Proveedor.class);
				configuration.addAnnotatedClass(Poliza.class);
				configuration.addAnnotatedClass(Hijo.class);
				configuration.addAnnotatedClass(HijoPoliza.class);
				configuration.addAnnotatedClass(Cobertura.class);
				configuration.addAnnotatedClass(CambioPoliza.class);
				configuration.addAnnotatedClass(PrecioProveedorTipo.class);
				configuration.addAnnotatedClass(MedidaSeguridad.class);
				configuration.addAnnotatedClass(Cuota.class);
				configuration.addAnnotatedClass(Pago.class);
				configuration.addAnnotatedClass(RegistroCambioProvincia.class);
				configuration.addAnnotatedClass(RegistroCambioLocalidad.class);
				configuration.addAnnotatedClass(RegistroCambioModelo.class);
				configuration.addAnnotatedClass(RegistroCambioCobertura.class);
				configuration.addAnnotatedClass(RegistroCambioMedSeg.class);
				configuration.addAnnotatedClass(PolizaMedidaSeguridad.class);
				configuration.addAnnotatedClass(PolizaMedidaSeguridadKey.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
