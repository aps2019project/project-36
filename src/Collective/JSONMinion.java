//package Collective;
//
//import org.json.simple.JSONObject;
//
//import java.io.FileWriter;
//
//public class JSONMinion {
//    public static void main(String[] args) {
//        JSONObject KamandareFars = new JSONObject();
//        KamandareFars.put("Name", "");
//        KamandareFars.put("Class", "Minion");
//        KamandareFars.put("price", "");
//        KamandareFars.put("neededManna", "");
//        KamandareFars.put("targetArea", "");
//        KamandareFars.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("KamandareFars.json")) {
//            file.write(KamandareFars.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject ShamshirZaneFars = new JSONObject();
//        ShamshirZaneFars.put("Name", "");
//        ShamshirZaneFars.put("Class", "");
//        ShamshirZaneFars.put("price", "");
//        ShamshirZaneFars.put("neededManna", "");
//        ShamshirZaneFars.put("targetArea", "");
//        ShamshirZaneFars.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("ShamshirZaneFars.json")) {
//            file.write(ShamshirZaneFars.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject NeizeDareFars = new JSONObject();
//        NeizeDareFars.put("Name", "");
//        NeizeDareFars.put("Class", "");
//        NeizeDareFars.put("price", "");
//        NeizeDareFars.put("neededManna", "");
//        NeizeDareFars.put("targetArea", "");
//        NeizeDareFars.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("NeizeDareFars.json")) {
//            file.write(NeizeDareFars.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject AsbSavareFars = new JSONObject();
//        AsbSavareFars.put("Name", "");
//        AsbSavareFars.put("Class", "");
//        AsbSavareFars.put("price", "");
//        AsbSavareFars.put("neededManna", "");
//        AsbSavareFars.put("targetArea", "");
//        AsbSavareFars.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("AsbSavareFars.json")) {
//            file.write(AsbSavareFars.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject PAhlavaneFars = new JSONObject();
//        PAhlavaneFars.put("Name", "");
//        PAhlavaneFars.put("Class", "");
//        PAhlavaneFars.put("price", "");
//        PAhlavaneFars.put("neededManna", "");
//        PAhlavaneFars.put("targetArea", "");
//        PAhlavaneFars.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("PAhlavaneFars.json")) {
//            file.write(PAhlavaneFars.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject SepahSalareFars = new JSONObject();
//        SepahSalareFars.put("Name", "");
//        SepahSalareFars.put("Class", "");
//        SepahSalareFars.put("price", "");
//        SepahSalareFars.put("neededManna", "");
//        SepahSalareFars.put("targetArea", "");
//        SepahSalareFars.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("SepahSalareFars.json")) {
//            file.write(SepahSalareFars.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject KAmandareToorani = new JSONObject();
//        KAmandareToorani.put("Name", "");
//        KAmandareToorani.put("Class", "");
//        KAmandareToorani.put("price", "");
//        KAmandareToorani.put("neededManna", "");
//        KAmandareToorani.put("targetArea", "");
//        KAmandareToorani.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("KAmandareToorani.json")) {
//            file.write(KAmandareToorani.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GhollabSangDareToorani = new JSONObject();
//        GhollabSangDareToorani.put("Name", "");
//        GhollabSangDareToorani.put("Class", "");
//        GhollabSangDareToorani.put("price", "");
//        GhollabSangDareToorani.put("neededManna", "");
//        GhollabSangDareToorani.put("targetArea", "");
//        GhollabSangDareToorani.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GhollabSangDareToorani.json")) {
//            file.write(GhollabSangDareToorani.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject NeizedareToorani = new JSONObject();
//        NeizedareToorani.put("Name", "");
//        NeizedareToorani.put("Class", "");
//        NeizedareToorani.put("price", "");
//        NeizedareToorani.put("neededManna", "");
//        NeizedareToorani.put("targetArea", "");
//        NeizedareToorani.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("NeizedareToorani.json")) {
//            file.write(NeizedareToorani.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject JAsooseToorani = new JSONObject();
//        JAsooseToorani.put("Name", "");
//        JAsooseToorani.put("Class", "");
//        JAsooseToorani.put("price", "");
//        JAsooseToorani.put("neededManna", "");
//        JAsooseToorani.put("targetArea", "");
//        JAsooseToorani.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("JAsooseToorani.json")) {
//            file.write(JAsooseToorani.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GorzdareToorani = new JSONObject();
//        GorzdareToorani.put("Name", "");
//        GorzdareToorani.put("Class", "");
//        GorzdareToorani.put("price", "");
//        GorzdareToorani.put("neededManna", "");
//        GorzdareToorani.put("targetArea", "");
//        GorzdareToorani.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GorzdareToorani.json")) {
//            file.write(GorzdareToorani.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject ShahzadeyeToorani = new JSONObject();
//        ShahzadeyeToorani.put("Name", "");
//        ShahzadeyeToorani.put("Class", "");
//        ShahzadeyeToorani.put("price", "");
//        ShahzadeyeToorani.put("neededManna", "");
//        ShahzadeyeToorani.put("targetArea", "");
//        ShahzadeyeToorani.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("ShahzadeyeToorani.json")) {
//            file.write(ShahzadeyeToorani.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject DiveSiah = new JSONObject();
//        DiveSiah.put("Name", "");
//        DiveSiah.put("Class", "");
//        DiveSiah.put("price", "");
//        DiveSiah.put("neededManna", "");
//        DiveSiah.put("targetArea", "");
//        DiveSiah.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("DiveSiah.json")) {
//            file.write(DiveSiah.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GhooleSangAndaz = new JSONObject();
//        GhooleSangAndaz.put("Name", "");
//        GhooleSangAndaz.put("Class", "");
//        GhooleSangAndaz.put("price", "");
//        GhooleSangAndaz.put("neededManna", "");
//        GhooleSangAndaz.put("targetArea", "");
//        GhooleSangAndaz.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GhooleSangAndaz.json")) {
//            file.write(GhooleSangAndaz.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Oghab = new JSONObject();
//        Oghab.put("Name", "");
//        Oghab.put("Class", "");
//        Oghab.put("price", "");
//        Oghab.put("neededManna", "");
//        Oghab.put("targetArea", "");
//        Oghab.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Oghab.json")) {
//            file.write(Oghab.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject DiveGorazSavar = new JSONObject();
//        DiveGorazSavar.put("Name", "");
//        DiveGorazSavar.put("Class", "");
//        DiveGorazSavar.put("price", "");
//        DiveGorazSavar.put("neededManna", "");
//        DiveGorazSavar.put("targetArea", "");
//        DiveGorazSavar.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("DiveGorazSavar.json")) {
//            file.write(DiveGorazSavar.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GhooleTakCheshm = new JSONObject();
//        GhooleTakCheshm.put("Name", "");
//        GhooleTakCheshm.put("Class", "");
//        GhooleTakCheshm.put("price", "");
//        GhooleTakCheshm.put("neededManna", "");
//        GhooleTakCheshm.put("targetArea", "");
//        GhooleTakCheshm.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GhooleTakCheshm.json")) {
//            file.write(GhooleTakCheshm.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject MAreSammi = new JSONObject();
//        MAreSammi.put("Name", "");
//        MAreSammi.put("Class", "");
//        MAreSammi.put("price", "");
//        MAreSammi.put("neededManna", "");
//        MAreSammi.put("targetArea", "");
//        MAreSammi.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("MAreSammi.json")) {
//            file.write(MAreSammi.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject EzhdehayeAtashAndaz = new JSONObject();
//        EzhdehayeAtashAndaz.put("Name", "");
//        EzhdehayeAtashAndaz.put("Class", "");
//        EzhdehayeAtashAndaz.put("price", "");
//        EzhdehayeAtashAndaz.put("neededManna", "");
//        EzhdehayeAtashAndaz.put("targetArea", "");
//        EzhdehayeAtashAndaz.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("EzhdehayeAtashAndaz.json")) {
//            file.write(EzhdehayeAtashAndaz.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject ShireDarande = new JSONObject();
//        ShireDarande.put("Name", "");
//        ShireDarande.put("Class", "");
//        ShireDarande.put("price", "");
//        ShireDarande.put("neededManna", "");
//        ShireDarande.put("targetArea", "");
//        ShireDarande.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("ShireDarande.json")) {
//            file.write(ShireDarande.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject MAreGhoolPEikar = new JSONObject();
//        MAreGhoolPEikar.put("Name", "");
//        MAreGhoolPEikar.put("Class", "");
//        MAreGhoolPEikar.put("price", "");
//        MAreGhoolPEikar.put("neededManna", "");
//        MAreGhoolPEikar.put("targetArea", "");
//        MAreGhoolPEikar.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("MAreGhoolPEikar.json")) {
//            file.write(MAreGhoolPEikar.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GorgeSefid = new JSONObject();
//        GorgeSefid.put("Name", "");
//        GorgeSefid.put("Class", "");
//        GorgeSefid.put("price", "");
//        GorgeSefid.put("neededManna", "");
//        GorgeSefid.put("targetArea", "");
//        GorgeSefid.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GorgeSefid.json")) {
//            file.write(GorgeSefid.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Palang = new JSONObject();
//        Palang.put("Name", "");
//        Palang.put("Class", "");
//        Palang.put("price", "");
//        Palang.put("neededManna", "");
//        Palang.put("targetArea", "");
//        Palang.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Palang.json")) {
//            file.write(Palang.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Gorg = new JSONObject();
//        Gorg.put("Name", "");
//        Gorg.put("Class", "");
//        Gorg.put("price", "");
//        Gorg.put("neededManna", "");
//        Gorg.put("targetArea", "");
//        Gorg.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Gorg.json")) {
//            file.write(Gorg.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Jadoogar = new JSONObject();
//        Jadoogar.put("Name", "");
//        Jadoogar.put("Class", "");
//        Jadoogar.put("price", "");
//        Jadoogar.put("neededManna", "");
//        Jadoogar.put("targetArea", "");
//        Jadoogar.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Jadoogar.json")) {
//            file.write(Jadoogar.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject JadoogareAzam = new JSONObject();
//        JadoogareAzam.put("Name", "");
//        JadoogareAzam.put("Class", "");
//        JadoogareAzam.put("price", "");
//        JadoogareAzam.put("neededManna", "");
//        JadoogareAzam.put("targetArea", "");
//        JadoogareAzam.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("JadoogareAzam.json")) {
//            file.write(JadoogareAzam.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Jen = new JSONObject();
//        Jen.put("Name", "");
//        Jen.put("Class", "");
//        Jen.put("price", "");
//        Jen.put("neededManna", "");
//        Jen.put("targetArea", "");
//        Jen.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Jen.json")) {
//            file.write(Jen.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GorazaVahshi = new JSONObject();
//        GorazaVahshi.put("Name", "");
//        GorazaVahshi.put("Class", "");
//        GorazaVahshi.put("price", "");
//        GorazaVahshi.put("neededManna", "");
//        GorazaVahshi.put("targetArea", "");
//        GorazaVahshi.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GorazaVahshi.json")) {
//            file.write(GorazaVahshi.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Piran = new JSONObject();
//        Piran.put("Name", "");
//        Piran.put("Class", "");
//        Piran.put("price", "");
//        Piran.put("neededManna", "");
//        Piran.put("targetArea", "");
//        Piran.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Piran.json")) {
//            file.write(Piran.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Giv = new JSONObject();
//        Giv.put("Name", "");
//        Giv.put("Class", "");
//        Giv.put("price", "");
//        Giv.put("neededManna", "");
//        Giv.put("targetArea", "");
//        Giv.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Giv.json")) {
//            file.write(Giv.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Bahman = new JSONObject();
//        Bahman.put("Name", "");
//        Bahman.put("Class", "");
//        Bahman.put("price", "");
//        Bahman.put("neededManna", "");
//        Bahman.put("targetArea", "");
//        Bahman.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Bahman.json")) {
//            file.write(Bahman.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Ashkboos = new JSONObject();
//        Ashkboos.put("Name", "");
//        Ashkboos.put("Class", "");
//        Ashkboos.put("price", "");
//        Ashkboos.put("neededManna", "");
//        Ashkboos.put("targetArea", "");
//        Ashkboos.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Ashkboos.json")) {
//            file.write(Ashkboos.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Iraj = new JSONObject();
//        Iraj.put("Name", "");
//        Iraj.put("Class", "");
//        Iraj.put("price", "");
//        Iraj.put("neededManna", "");
//        Iraj.put("targetArea", "");
//        Iraj.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Iraj.json")) {
//            file.write(Iraj.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GhooleBozorg = new JSONObject();
//        GhooleBozorg.put("Name", "");
//        GhooleBozorg.put("Class", "");
//        GhooleBozorg.put("price", "");
//        GhooleBozorg.put("neededManna", "");
//        GhooleBozorg.put("targetArea", "");
//        GhooleBozorg.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GhooleBozorg.json")) {
//            file.write(GhooleBozorg.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GhooleDoSar = new JSONObject();
//        GhooleDoSar.put("Name", "");
//        GhooleDoSar.put("Class", "");
//        GhooleDoSar.put("price", "");
//        GhooleDoSar.put("neededManna", "");
//        GhooleDoSar.put("targetArea", "");
//        GhooleDoSar.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("GhooleDoSar.json")) {
//            file.write(GhooleDoSar.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject NAnaSarma = new JSONObject();
//        NAnaSarma.put("Name", "");
//        NAnaSarma.put("Class", "");
//        NAnaSarma.put("price", "");
//        NAnaSarma.put("neededManna", "");
//        NAnaSarma.put("targetArea", "");
//        NAnaSarma.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("NAnaSarma.json")) {
//            file.write(NAnaSarma.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject FooladZere = new JSONObject();
//        FooladZere.put("Name", "");
//        FooladZere.put("Class", "");
//        FooladZere.put("price", "");
//        FooladZere.put("neededManna", "");
//        FooladZere.put("targetArea", "");
//        FooladZere.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("FooladZere.json")) {
//            file.write(FooladZere.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Siavash = new JSONObject();
//        Siavash.put("Name", "");
//        Siavash.put("Class", "");
//        Siavash.put("price", "");
//        Siavash.put("neededManna", "");
//        Siavash.put("targetArea", "");
//        Siavash.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("Siavash.json")) {
//            file.write(Siavash.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject ShahGhool = new JSONObject();
//        ShahGhool.put("Name", "");
//        ShahGhool.put("Class", "");
//        ShahGhool.put("price", "");
//        ShahGhool.put("neededManna", "");
//        ShahGhool.put("targetArea", "");
//        ShahGhool.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("ShahGhool.json")) {
//            file.write(ShahGhool.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject ArzhangDiv = new JSONObject();
//        ArzhangDiv.put("Name", "");
//        ArzhangDiv.put("Class", "");
//        ArzhangDiv.put("price", "");
//        ArzhangDiv.put("neededManna", "");
//        ArzhangDiv.put("targetArea", "");
//        ArzhangDiv.put("Effect", "");
//        try (
//                FileWriter file = new FileWriter("ArzhangDiv.json")) {
//            file.write(ArzhangDiv.toString());
//            file.flush();
//            file.close();
//        }
//    }
//}
