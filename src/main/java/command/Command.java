package command;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import simulator.Grid;

/**
 *
 * @author gigadot
 */
public interface Command {

    void apply();

    void apply(String name);

}
