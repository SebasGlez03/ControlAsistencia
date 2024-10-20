///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package dtos;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
///**
// *
// * @author joel_
// */
//public class MaestroDTOTest {
//    
//    public MaestroDTOTest() {
//    
//    }
//    @Test
//    public void testGetMateria() {
//    List<String> materias= new ArrayList<>();
//    MaestroDTO dto = new MaestroDTO(materias, "joel", "joel.cabe2403"
//            , 0, "asdf");
//    materias.add("español");
//    materias.add("ingles");
//    materias.add("matematicas");
//    
//    dto.getMateria();
//    String[] lista={"español","ingles","matematicas"};
//    assertEquals(dto.getMateria(),new ArrayList<String>(Arrays.asList(lista)) );
//    }
//
//    @Test
//    public void testSetMateria() {
//    List<String> materias= new ArrayList<>();
//    MaestroDTO dto = new MaestroDTO(materias, "joel", "joel.cabe2403"
//            , 0, "asdf");
//    materias.add("español");
//    materias.add("ingles");
//    materias.add("matematicas");
//    
//    dto.setMateria(materias);
//    }
//
//    @Test
//    public void testAgregarMateria() {
//    }
//
//    @Test
//    public void testEliminarMateria() {
//    }
//
//    
//}
