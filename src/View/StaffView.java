package View;

import Business.*;
import Entity.Hotel;
import Entity.Pension;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.util.ArrayList;

public class StaffView  extends Layout{

    private User user;
    private UserManager userManager;
    private HotelManager hotelManager;
    private PensionManager pensionManager;
    private SeasonManager seasonManager;
    private RoomManager roomManager;
    private ReservationManager reservationManager;
    private final DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private final DefaultTableModel tmdl_pension = new DefaultTableModel();
    private final DefaultTableModel tmdl_season = new DefaultTableModel();
    private final DefaultTableModel tmdl_room = new DefaultTableModel();
    private final DefaultTableModel tmdl_reservation = new DefaultTableModel();
    private Object[] col_pension_list;
    private Object[] col_hotel_list;
    private Object[]
    private Object[]



    private JPanel container;
    private JPanel pnl_bottom;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_hotel_manager;
    private JPanel pnl_room_manager;
    private JPanel pnl_reservations_manager;
    private JButton button2;
    private JButton btn_hotel_add;
    private JButton btn_add_hotel;
    private JTable tbl_hotel;
    private JTable tbl_hotel_manager_pensions;
    private JTable tbl_hotel_manager_seasons;

    public StaffView(User user) {
        this.userManager = new UserManager();
        this.hotelManager = new HotelManager();
        this.pensionManager = new PensionManager();
        this.seasonManager = new SeasonManager();
        this.roomManager = new RoomManager();
        this.reservationManager = new ReservationManager();
        this.add(container);
        guiInitialize(600,600);
        this.user=user;
//      this.lbl_welcome.setText("Welcome : " + this.user.getUsername());

        loadComponent();
        loadHotelTable();
        loadHotelComponent();
        loadPensionTable(null);
        loadPensionComponent();
    }
    private void loadPensionTable () {
        col_pension_list = new Object [] {"Pension id","Hotel name","Pension type"};
        ArrayList<Object[]> pensionList = this.pensionManager.getForTable(col_pension_list.length,this.pensionManager.findAll());

        createTable(this.tmdl_pension,this.tbl_pension,col_pension_list, pensionList);
    }
    private void loadHotelTable() {
        col_hotel_list = new Object[] {"Hotel id","Hotel name","City","Address",
                "E-Mail","Phone","Star","Parking","Wifi","Swimming pool","Fitness center",
                "Concierge","Spa","7/24 Room service",};
        hotelList = this.hotelManager.getForTable(col_hotel_list.length,this.hotelManager.findAll());
        createTable(this.tmdl_hotel, this.tbl_hotel, col_hotel_list, hotelList);
    }
    private void loadHotelComponent(){
        tableRowSelect(tbl_hotel);
        this.hotel_menu = new JPopupMenu();
        this.hotel_menu.add("Add Pension").addActionListener(e->{
            PensionView pensionView = new PensionView(new Pension());
            pensionView.addWindowListener(WindowAdapter) windowClosed(e) -> {
                loadPensionTable(null);
            });
        });
        this.hotel_menu.add("Add Season").addActionListener(e->) {
            SeasonView seasonView = new SeasonView();
            seasonView.addWindowListener(WindowAdapter) windowClosed(e) -> {
                loadPensionTable(null);
            });
        }
        btn_hotel_add.addActionListener(e -> {
            HotelView hotelView = new HotelView(new Hotel());
            hotelView.addWindowListener(WindowAdapter) windowClosed(e) ->{
                loadHotelTable(null);
            });
        });
        this.tbl_hotel setCommentPopupMenu(hotel_menu);
    }
    private void loadComponent() {
        /// vid 4:10
    }
    private void createUiComponents() throws ParseException {
        this.fld_room_start_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_room_end_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_room_start_date.setText("01/01/2023");
        this.fld_room_end_date.setText("01/01/2023");
    }
}
